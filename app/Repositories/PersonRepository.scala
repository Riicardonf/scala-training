package Repositories

import javax.inject.{Inject, Singleton}
import models.Person
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

/**
  *
  * @param dbConfigProvider (Injeção da conexão com Banco de dados)
  * @param ec
  */

@Singleton
class PersonRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {

  // Recuperando o DB ( É possível passar como paramêtro  da classe )
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  // Onde é o melhor lugar para se definir essa classe
  private class PersonTable(tag: Tag) extends Table[Person](tag, "person"){
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    // Define como é a table no Banco de dados e converte para o objeto Pessoa

    // Passa os parametros para o person case class

    def * = (id, name, age) <> ((Person.apply _).tupled, Person.unapply)
    // Mapeia a tabela .. ( O método "TUPLED" converte uma função com vários argumentos para uma com apenas um argumento)

  }

  // Pega a tabela
  private val person = TableQuery[PersonTable]

  // Requisição Async que cria e no final retorna a pessoa
  def create(name: String, age: Int): Future[Person] = db.run {
    (person.map( p => (p.name, p.age))
      returning person.map(_.id)
      //retorna o ID que foi criado

      into ((nameAge, id) => Person(id, nameAge._1, nameAge._2)) // Porque
      ) += (name, age)
  }

  // Lista todos as pessoas no banco
  def list(): Future[Seq[Person]] = db.run {
    person.result
  }

  def show(id: Long): Future[Option[Person]] = db.run {
    person.filter(_.id === id).result.headOption

  }
}
