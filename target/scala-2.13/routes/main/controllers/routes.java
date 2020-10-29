// @GENERATOR:play-routes-compiler
// @SOURCE:R:/JavaProjects/ScalaAPI/conf/routes
// @DATE:Wed Oct 28 21:41:06 BRT 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePersonController PersonController = new controllers.ReversePersonController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePersonController PersonController = new controllers.javascript.ReversePersonController(RoutesPrefix.byNamePrefix());
  }

}
