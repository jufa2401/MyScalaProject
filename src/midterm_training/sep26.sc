import java.util.function.IntFunction

class Number(val value: Int) { override def toString = "Number(" + value + ")" }

def lift(intFunction: Int => Int) = {
  def function(v:Number) = new Number(intFunction(v.value))
  function _
}
val numSquare = lift((n: Int) => n * n)
numSquare(new Number(2))




//map2(List(2, 3, 4), List(6, 7, 8), (x: Int, y: Int) => x + y)

//val numSquare = lift((n: Int) => n * n)