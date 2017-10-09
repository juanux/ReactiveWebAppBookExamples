package controllers

import javax.inject.Inject

import akka.actor.{ Actor, ActorRef, Props }
import play.api.i18n.Lang
import play.api.mvc._
import services.VocabularyService
import play.api.Play.current

class Quiz @Inject() (vocabulary: VocabularyService) extends Controller {

  def quiz(sourceLanguage: Lang, targetLanguage: Lang): Action[AnyContent] = Action { request =>

    vocabulary.findRandomVocabulary(sourceLanguage, targetLanguage) match {
      case Some(word) => Ok(word.word)
      case None => NotFound
    }

  }

  def check(sourceLanguage: Lang, word: String, targetLanguage: Lang, translation: String) = Action { request =>

    val isCorrect = vocabulary.verify(sourceLanguage, word, targetLanguage, translation)

    val correctScore = request.session.get("correct").map(_.toInt).getOrElse(0)

    val wrongScore = request.session.get("wrong").map(_.toInt).getOrElse(0)

    if (isCorrect) {
      Ok.withSession("correct" -> (correctScore + 1).toString, "wrong" -> wrongScore.toString)
    } else {
      NotAcceptable.withSession("correct" -> correctScore.toString, "wrong" -> (wrongScore + 1).toString)
    }

  }

  def quizEndPoint(sourceLang: Lang, targetLang: Lang) = WebSocket.acceptWithActor[String, String] {
    request =>
      out => QuizActor.props(out, sourceLang, targetLang, vocabulary)
  }

}

class QuizActor(out: ActorRef,
    sourceLang: Lang,
    targetLang: Lang,
    vocabulary: VocabularyService) extends Actor {

  private var word = ""

  override def preStart(): Unit = sendWord()

  def receive: Receive = {

    case translation: String if vocabulary.verify(sourceLang, word, targetLang, translation) =>
      out ! "Correct"
      sendWord()
    case _ => out ! "Incorrect, try again!"

  }

  def sendWord(): Unit = {

    vocabulary.findRandomVocabulary(sourceLang, targetLang).map { v =>

      out ! s"Please translate '${v.word}'"
      word = v.word

    }.getOrElse {

      out ! s"I don`t know any word for ${sourceLang.code} and ${targetLang.code}"

    }

  }

}

object QuizActor {

  def props(out: ActorRef, sourceLang: Lang, targetLang: Lang, vocabulary: VocabularyService): Props = Props(classOf[QuizActor], out, sourceLang, targetLang, vocabulary)

}