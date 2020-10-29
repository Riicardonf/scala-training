// @GENERATOR:play-routes-compiler
// @SOURCE:R:/JavaProjects/ScalaAPI/conf/routes
// @DATE:Wed Oct 28 21:41:06 BRT 2020


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
