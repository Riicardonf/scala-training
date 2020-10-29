// @GENERATOR:play-routes-compiler
// @SOURCE:R:/JavaProjects/ScalaAPI/conf/routes
// @DATE:Wed Oct 28 21:41:06 BRT 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  PersonController_0: controllers.PersonController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    PersonController_0: controllers.PersonController
  ) = this(errorHandler, PersonController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PersonController.index"""),
    ("""POST""", this.prefix, """controllers.PersonController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/""" + "$" + """id<[^/]+>""", """controllers.PersonController.show(id:Long)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_PersonController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_index0_invoker = createInvoker(
    PersonController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_PersonController_create1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_create1_invoker = createInvoker(
    PersonController_0.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "create",
      Nil,
      "POST",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_PersonController_show2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PersonController_show2_invoker = createInvoker(
    PersonController_0.show(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "show",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """person/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_PersonController_index0_route(params@_) =>
      call { 
        controllers_PersonController_index0_invoker.call(PersonController_0.index)
      }
  
    // @LINE:4
    case controllers_PersonController_create1_route(params@_) =>
      call { 
        controllers_PersonController_create1_invoker.call(PersonController_0.create)
      }
  
    // @LINE:6
    case controllers_PersonController_show2_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PersonController_show2_invoker.call(PersonController_0.show(id))
      }
  }
}
