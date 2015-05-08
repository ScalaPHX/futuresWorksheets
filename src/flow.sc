import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

// how to recover from errors...gracefully
def divide(i : Int) : Future[Either[String, Int]] = Future {
  Right(42 / i)
} recover {
  case e : ArithmeticException => Left("∞")
}

divide(2).map(println(_))

// how to fallback to another async calculation
val f1 = Future {
  Thread.sleep(500)
  1 / 0
}

val f2 = Future {
  Thread.sleep(500)
  "∞"
}

f1.fallbackTo(f2).map(println)

println("Try dividing by zero, fallback to another future..")

Thread.sleep(2000)

// serially execute multiple side effects in a specific order
val serialFutures = Future {
  Thread.sleep(500)
  println("First async call...")
  1
} andThen {
  case _ =>
    Thread.sleep(500)
    println("second async call...")

} andThen {
  case _ =>
    Thread.sleep(500)
    println("final async call...")
}

Console.println("Ordered calls...")

Thread.sleep(2000)

serialFutures.map(println)
