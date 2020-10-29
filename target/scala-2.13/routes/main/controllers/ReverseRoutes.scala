// @GENERATOR:play-routes-compiler
// @SOURCE:R:/JavaProjects/ScalaAPI/conf/routes
// @DATE:Wed Oct 28 21:41:06 BRT 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:2
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def create(): Call = {
      
      Call("POST", _prefix)
    }
  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:6
    def show(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "person/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
