import akka.actor.{ActorSystem, Props}

case class Ticket(quantity: Int)
case class FullPint(number: Int)
case class EmptyPint(number: Int)

object AkkaMain extends App {
  val system = ActorSystem("hello-akka")

  val zed = system.actorOf(Props(new BarTender), "zed")

  val allan   = system.actorOf(Props(new Person), "allan")
  val alice     = system.actorOf(Props(new Person), "alice")
  val charlie = system.actorOf(Props(new Person), "charlie")

  zed.tell(Ticket(2), allan)
  zed.tell(Ticket(3), alice)
  zed.tell(Ticket(1), charlie)

  system.awaitTermination()
}
