package controllers

import javax.inject.Inject

import models.Vocabulary
import play.api.i18n.Lang
import play.api.mvc._
import services.VocabularyService

class Import @Inject() (vocabulary: VocabularyService) extends Controller {

  def importWord(sourceLanguage: Lang, word: String, targerLanguage: Lang, translation: String) = Action { request =>

    val added = vocabulary.addVocabulary(Vocabulary(sourceLanguage, targerLanguage, word, translation))

    if (added) Ok
    else Conflict

  }

}
