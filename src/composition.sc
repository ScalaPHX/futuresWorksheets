import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

def increment(i : Int) = i + 1

val futureFirst = Future(increment(3))

val futureSecond = Future(increment(4))


//val futureSum = futureFirst.map {
//  result =>
//    futureSecond.map {
//      secondResult =>
//        result + secondResult
//    }
//}
//
//
//val flatSum = futureFirst.flatMap {
//  result => futureSecond.map {
//    secondResult =>
//      result + secondResult
//  }
//}
//
//
//
//val sum = for {
//  first <- futureFirst
//  second <- futureSecond
//} yield first + second
//
//sum.onSuccess {
//  case result => println(s"result : $result")
//}

