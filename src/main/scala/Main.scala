import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.Await
import scala.util.{Failure, Success}

object Main extends App {

  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem(name = "todoApi")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  import system.dispatcher

  val todoRepository = new InMemoryTodoRepository(Seq(
    Todo(1, "Buy Eggs", "Ran out of eggs, buy a dozen when heading out", false),
    Todo(2, "Buy Milk", "The cat drank all the milk, need to buy a litre", true)
  ))
  val router = new TodoRouter(todoRepository)
  val server = new Server(router, host, port)

  val bindingFuture = server.bind()

  bindingFuture.onComplete {
    case Success(binding) => println(s"Server listening on ${binding.localAddress}")
    case Failure(error) => println(s"Error: ${error.getMessage}")
  }

  import scala.concurrent.duration._
  Await.result(bindingFuture, 3.seconds)
}