// @GENERATOR:play-routes-compiler
// @SOURCE:R:/JavaProjects/ScalaAPI/conf/routes
// @DATE:Tue Nov 03 23:05:19 BRST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:2
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "person/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:4
    def show(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "person/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:3
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "person")
    }
  
    // @LINE:5
    def update(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "person/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "person")
    }
  
  }


}
