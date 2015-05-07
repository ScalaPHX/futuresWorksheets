import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

def increment(i : Int) = i + 1

val f = Future {
  Thread.sleep(500)
  increment(2)
}

Await.result(f, 501 millis)   // VERY bad - don't use this unless you need to!


f.onComplete {
  case Success(result) => println(s"Incremented value: $result")
  case Failure(e) => println(s"Error : ${e.getMessage}")
}

f.onSuccess {
  case result => println(s"Success, result -> $result")
}

val f2 = Future[Int] {
  throw new Exception("Big Ba-da-boooom!")
}

f2.onComplete {
  case Success(result) => println(s"Something we should never see...: $result")
  case Failure(e) => println(s"Error : ${e.getMessage}")
}

f2.onFailure {
  case e => e.printStackTrace()
}