
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/juanjosemorales/ReactiveWebAppBookExamples/vocabulary-teacher/conf/routes
// @DATE:Sun Oct 08 22:52:13 COT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.binders.PathBinders._
import _root_.binders.QueryStringBinders._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  Import_0: controllers.Import,
  // @LINE:3
  Quiz_1: controllers.Quiz,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    Import_0: controllers.Import,
    // @LINE:3
    Quiz_1: controllers.Quiz
  ) = this(errorHandler, Import_0, Quiz_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Import_0, Quiz_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """import/word/$sourceLang<[^/]+>/$word<[^/]+>/$targetLang<[^/]+>/$translation<[^/]+>""", """controllers.Import.importWord(sourceLang:play.api.i18n.Lang, word:String, targetLang:play.api.i18n.Lang, translation:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """quiz/$sourceLang<[^/]+>""", """controllers.Quiz.quiz(sourceLang:play.api.i18n.Lang, targetLang:play.api.i18n.Lang)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """quiz/$sourceLang<[^/]+>/check/$word<[^/]+>""", """controllers.Quiz.check(sourceLang:play.api.i18n.Lang, word:String, targetLang:play.api.i18n.Lang, translation:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """quiz/interactive/$sourceLang<[^/]+>/$targetLang<[^/]+>""", """controllers.Quiz.quizEndPoint(sourceLang:play.api.i18n.Lang, targetLang:play.api.i18n.Lang)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_Import_importWord0_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("import/word/"), DynamicPart("sourceLang", """[^/]+""",true), StaticPart("/"), DynamicPart("word", """[^/]+""",true), StaticPart("/"), DynamicPart("targetLang", """[^/]+""",true), StaticPart("/"), DynamicPart("translation", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Import_importWord0_invoker = createInvoker(
    Import_0.importWord(fakeValue[play.api.i18n.Lang], fakeValue[String], fakeValue[play.api.i18n.Lang], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Import",
      "importWord",
      Seq(classOf[play.api.i18n.Lang], classOf[String], classOf[play.api.i18n.Lang], classOf[String]),
      "PUT",
      """""",
      this.prefix + """import/word/$sourceLang<[^/]+>/$word<[^/]+>/$targetLang<[^/]+>/$translation<[^/]+>"""
    )
  )

  // @LINE:3
  private[this] lazy val controllers_Quiz_quiz1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("quiz/"), DynamicPart("sourceLang", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Quiz_quiz1_invoker = createInvoker(
    Quiz_1.quiz(fakeValue[play.api.i18n.Lang], fakeValue[play.api.i18n.Lang]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Quiz",
      "quiz",
      Seq(classOf[play.api.i18n.Lang], classOf[play.api.i18n.Lang]),
      "GET",
      """""",
      this.prefix + """quiz/$sourceLang<[^/]+>"""
    )
  )

  // @LINE:4
  private[this] lazy val controllers_Quiz_check2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("quiz/"), DynamicPart("sourceLang", """[^/]+""",true), StaticPart("/check/"), DynamicPart("word", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Quiz_check2_invoker = createInvoker(
    Quiz_1.check(fakeValue[play.api.i18n.Lang], fakeValue[String], fakeValue[play.api.i18n.Lang], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Quiz",
      "check",
      Seq(classOf[play.api.i18n.Lang], classOf[String], classOf[play.api.i18n.Lang], classOf[String]),
      "POST",
      """""",
      this.prefix + """quiz/$sourceLang<[^/]+>/check/$word<[^/]+>"""
    )
  )

  // @LINE:5
  private[this] lazy val controllers_Quiz_quizEndPoint3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("quiz/interactive/"), DynamicPart("sourceLang", """[^/]+""",true), StaticPart("/"), DynamicPart("targetLang", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Quiz_quizEndPoint3_invoker = createInvoker(
    Quiz_1.quizEndPoint(fakeValue[play.api.i18n.Lang], fakeValue[play.api.i18n.Lang]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Quiz",
      "quizEndPoint",
      Seq(classOf[play.api.i18n.Lang], classOf[play.api.i18n.Lang]),
      "GET",
      """""",
      this.prefix + """quiz/interactive/$sourceLang<[^/]+>/$targetLang<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_Import_importWord0_route(params) =>
      call(params.fromPath[play.api.i18n.Lang]("sourceLang", None), params.fromPath[String]("word", None), params.fromPath[play.api.i18n.Lang]("targetLang", None), params.fromPath[String]("translation", None)) { (sourceLang, word, targetLang, translation) =>
        controllers_Import_importWord0_invoker.call(Import_0.importWord(sourceLang, word, targetLang, translation))
      }
  
    // @LINE:3
    case controllers_Quiz_quiz1_route(params) =>
      call(params.fromPath[play.api.i18n.Lang]("sourceLang", None), params.fromQuery[play.api.i18n.Lang]("targetLang", None)) { (sourceLang, targetLang) =>
        controllers_Quiz_quiz1_invoker.call(Quiz_1.quiz(sourceLang, targetLang))
      }
  
    // @LINE:4
    case controllers_Quiz_check2_route(params) =>
      call(params.fromPath[play.api.i18n.Lang]("sourceLang", None), params.fromPath[String]("word", None), params.fromQuery[play.api.i18n.Lang]("targetLang", None), params.fromQuery[String]("translation", None)) { (sourceLang, word, targetLang, translation) =>
        controllers_Quiz_check2_invoker.call(Quiz_1.check(sourceLang, word, targetLang, translation))
      }
  
    // @LINE:5
    case controllers_Quiz_quizEndPoint3_route(params) =>
      call(params.fromPath[play.api.i18n.Lang]("sourceLang", None), params.fromPath[play.api.i18n.Lang]("targetLang", None)) { (sourceLang, targetLang) =>
        controllers_Quiz_quizEndPoint3_invoker.call(Quiz_1.quizEndPoint(sourceLang, targetLang))
      }
  }
}