import scalaz._
import Scalaz._
def square(x: Int) = x * x
def noisySquare(x: Int) = { println("squaring " + x); square(x)}
lazy val hundred = noisySquare(10)

3+hundred
5+hundred


val inc = (v: Double) => v +1
val double = (v: Double) => v * 2
//val coolThing = inc _ compose double _


def square2(x: Double) = x*x
def iterSquare(init: Double, n: Int) = {
  var result = init
  for(i <- 0 to n) result = square2(result)
  result
}
def selfAppend(x: String) = x+x
def iterF[T](f: T => T, init: T, n: Int) = {
  var result = init
  for(i <- 0 to n) result = f(result)
  result

}
iterF(square,2,3)
iterF(math.sin(_),3.14,4)
iterF(selfAppend,"Hello",4)

// CoolOption Shit
val o1: Option[Int] = Some(20)
val o2: Option[Int] = None
val istheresomethingO1 = o1.getOrElse(0)
val istheresomethingO2 = o2.getOrElse(0)

o1 match {
  case Some(value) => value + 100
  case None =>  0
}
o1.map(x => x+100)
// Adds 100 if it is Some
o2.map(x=> x+100)
// Adds 50 to o1 if it is greater than 50 and Some
o1.filter(x => x > 50).map(x => x+50)

val o3: Option[Int] = Some(3000)

val toOptionsTogether = o3|+|o2