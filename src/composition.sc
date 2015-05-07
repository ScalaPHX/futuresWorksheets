import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

def increment(i : Int) = i + 1

val futureFirst = Future {
  Thread.sleep(1000)
  println("first increment...")
  increment(3)
}

val futureSecond = Future {
  println("second increment...")
  increment(4)
}

// what type do we get here?
//val futureSum = futureFirst.map {
//  result =>
//    futureSecond.map {
//      secondResult =>
//        result + secondResult
//    }
//}
//
// what type would we get with this?
//val flatSum = futureFirst.flatMap {
//  result => futureSecond.map {
//    secondResult =>
//      result + secondResult
//  }
//}
//
// For comprehension use for Futures
//val sum = for {
//  first <- Future {
//    println("first...")
//    1
//  }
//  second <- Future{
//    println("second...")
//    Thread.sleep(500)
//    2
//  }
//} yield first + second
//
//sum.map(println)

//
// For comprehension - execute Futures asynchronously and join the results

//val asyncSum = for {
//  first <- futureFirst
//  second <- futureSecond
//} yield first + second
//
//asyncSum.onSuccess {
//  case result => println(s"result : $result")
//}