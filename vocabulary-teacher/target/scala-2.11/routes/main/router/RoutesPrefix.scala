
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/juanjosemorales/ReactiveWebAppBookExamples/vocabulary-teacher/conf/routes
// @DATE:Sun Oct 08 22:52:13 COT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
