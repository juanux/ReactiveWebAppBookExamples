
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/juanjosemorales/ReactiveWebAppBookExamples/vocabulary-teacher/conf/routes
// @DATE:Sun Oct 08 22:52:13 COT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.binders.PathBinders._
import _root_.binders.QueryStringBinders._

// @LINE:1
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:1
  class ReverseImport(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def importWord: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Import.importWord",
      """
        function(sourceLang,word,targetLang,translation) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "import/word/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("sourceLang", sourceLang) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("word", encodeURIComponent(word)) + "/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("targetLang", targetLang) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("translation", encodeURIComponent(translation))})
        }
      """
    )
  
  }

  // @LINE:3
  class ReverseQuiz(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def quiz: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Quiz.quiz",
      """
        function(sourceLang,targetLang) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("sourceLang", sourceLang) + _qS([(""" + implicitly[QueryStringBindable[play.api.i18n.Lang]].javascriptUnbind + """)("targetLang", targetLang)])})
        }
      """
    )
  
    // @LINE:4
    def check: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Quiz.check",
      """
        function(sourceLang,word,targetLang,translation) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("sourceLang", sourceLang) + "/check/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("word", encodeURIComponent(word)) + _qS([(""" + implicitly[QueryStringBindable[play.api.i18n.Lang]].javascriptUnbind + """)("targetLang", targetLang), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("translation", translation)])})
        }
      """
    )
  
    // @LINE:5
    def quizEndPoint: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Quiz.quizEndPoint",
      """
        function(sourceLang,targetLang) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "quiz/interactive/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("sourceLang", sourceLang) + "/" + (""" + implicitly[PathBindable[play.api.i18n.Lang]].javascriptUnbind + """)("targetLang", targetLang)})
        }
      """
    )
  
  }


}