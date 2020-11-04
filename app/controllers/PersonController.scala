package controllers

import Repositories.PersonRepository
import javax.inject.Inject
import models.Person
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number}
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class PersonController @Inject()(repository: PersonRepository, controllerComponents: ControllerComponents)(implicit ec: ExecutionContext)
  extends AbstractController(controllerComponents) {

  val personForm: Form[CreatePersonForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "age" -> number
    )(CreatePersonForm.apply)(CreatePersonForm.unapply)
  }

  def index = Action.async { implicit request: Request[AnyContent] =>
      repository.list().map { p => Ok(Json.toJson(p))
    }
  }

  def create = Action.async { implicit  request =>
    personForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Redirect(routes.PersonController.index()))
      },
      person => {
        repository.create(person.name, person.age).map(_ =>
          Redirect(routes.PersonController.index())
        )
      }
    )
  }

  def show(id: Long) = Action.async { implicit request =>
      repository.show(id).map { p =>
           Ok(Json.toJson(p)).as("application/json")
        }
  }

  def update(id: Long) = Action.async { implicit request =>
    personForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Redirect(routes.PersonController.index()))
      },
      person => {
        repository.update(person.name, person.age, id: Long).map {
          case true => Ok(Json.obj("status" -> "sucess")).as("application/json")
          case false => UnprocessableEntity
        }.recoverWith{
          case e => Future { InternalServerError("Error: " + e)}
        }
      }
    )
  }

  def delete(id: Long) = Action.async { implicit request =>
    repository.delete(id).map {
      case true => Ok(Json.obj("status" -> "success")).as("application/json")
      case false => UnprocessableEntity
    }.recoverWith{
      case e => Future { InternalServerError("ERROR: " + e) }
    }
  }


}


case class CreatePersonForm(name: String, age: Int)