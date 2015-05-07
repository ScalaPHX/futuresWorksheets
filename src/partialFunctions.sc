def increment(i : Int) = i + 1

//increment(2)

def divide(i : Int) = 42 / i

//divide(2)

//divide(0)

val dividePartial : PartialFunction[Int, Int] = {
  case i : Int if i != 0 => 42 / i
  //case i : Int if i == 0 => 42
}

//dividePartial.isDefinedAt(2)

//dividePartial.isDefinedAt(0)

//dividePartial(2)

//dividePartial(0)