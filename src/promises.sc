import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
// Promises, Promises...

// Typesafe way to deal with Futures

// simple example
val promise = Promise[Int]()

val futureResults = promise.future

futureResults.map {
  r => println(s"Results : $r")
}

promise.success(42)

// more likely usage pattern...

val anotherPromise = Promise[Int]()

Future {
  println("Another future...")
  Thread.sleep(1000)
  anotherPromise.success(42)
}

anotherPromise.future.onSuccess {
  case results => println(s"More Results : $results")
}