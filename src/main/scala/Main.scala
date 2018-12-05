import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Main extends App {
  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem(name = "todoApi")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  import system.dispatcher
}
