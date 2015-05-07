import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val complex = Seq(Future(1), Future(2), Future(3))

// how to process this??

//val simplified = Future.sequence(complex)

//simplified.map(_.map(println(_)))

// I don't care which one I get, I just want an answer fast!
val f1 = Future("I'm first!")
val f2 = Future("I'm second!")

//Future.firstCompletedOf(Seq(f1, f2))

val two = Future.find(complex)(_ == 2) // return me a Future that matches the optional first result of the finder

//two.map {
//  result => println(s"found it! $result")
//}
//
//val notFound = Future.find(complex)(_ == 300)
//
//notFound.map {
//  result => println(s"results: $result")
//}
//
//val greaterThan = Future.find(complex)(_ >= 2)
//
//greaterThan.map {
//  result => println(s"results: $result")
//}
