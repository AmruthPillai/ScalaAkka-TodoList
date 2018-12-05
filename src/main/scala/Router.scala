import akka.http.scaladsl.server.{Directives, Route}

trait Router {

  def Route: Route

}


class TodoRouter(todoRepository: TodoRepository) extends Router with Directives {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  override def Route: Route = pathPrefix("todos") {
    get {
      complete(todoRepository.all())
    }
  }

}