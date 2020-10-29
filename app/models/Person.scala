package models

import play.api.libs.json.{Json, OFormat}

// Define a classe Person do jeito que ela é no banco
case class Person(id: Long, name: String, age: Int)

object Person {

  //Definindo como "OFormat" é possível usar a funções da lib do JSON; (Filter, map , etc.. )
  implicit val personFormat: OFormat[Person] = Json.format[Person]

}