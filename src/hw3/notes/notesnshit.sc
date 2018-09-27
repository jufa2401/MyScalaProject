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
iterF(square,2,1)
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



// Different way of using the type parameter. Bubblesort that works on all subtypes of ordered
def bubbleSort[A <% Ordered[A]](a:Array[A]) {
  for (i<-0 until a.length-1) {
    for(j<-0 until a.length-1-i) {
      if(a(j+1)<a(j)) { // Since we specified that the type is ordered we can do < operator on the test
        val temp = a(j)
        a(j) = a(j+1)
        a(j+1)=temp
      }
    }
  }
}
var v = Array(10,12,2,5,1)
var s = Array(10.33f,12.31f,44.21f,66.22f,1010.2f)
var s2 = Array("10.33","12.31","44.21","66.22","1010.120")

bubbleSort(v)
bubbleSort(s)
bubbleSort(s2)
println(v.mkString(", "))
println(s.mkString(", "))
println(s2.mkString(", "))