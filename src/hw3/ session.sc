

//
//def compose(f: Int=>Int, g: Int=>Int): Int=>Int = {
//  def r(x: Int): Int = f(g(x))
//  r _
//}
def triple(x: Int): Int = 3 * x
def square(x: Int) = x * x
//val squareTriple = compose(square ­_, triple _)


val inc = (v: Double) => v +1
val double = (v: Double) => v * 2





//def compose[A,B,C](f: B => C, g: A => B, x: A): C = f(g(x))
//compose(inc, double, 2)


// 1. Problem
def compose[T](f:T=>T, g:T=>T):T=> T=(x:T) => f(g(x))
// 2. Problem
def selfIter[T](f: T=> T, n: Int): T => T = {
  if(n == 1) f
  else compose(f,selfIter(f,n-1))
}
// 3. Problem
def countPass[T](testArray: T => Boolean, p: Array[T]):Int = p.count(testArray)
countPass((x: Float) => x > 0, Array(5.3f, 10.3f, 16.4f, 25.3f, 33.3f))

// 4. Problem
def recur(baseVal: Int, combiner: (Int,Int) => Int): Int => Int = {
  def helper(n:Int): Int = {
    print(n)
    if(n == 0) baseVal
    else combiner(n,helper(n-1))
  }
  helper
}

//cool shit
recur(1, (a: Int, b: Int) => a * b)(4) // factorial

lazy val ass = recur(1, (a: Int, b: Int) => a * b)
ass(4)



def parseDigits(digits: String): Option[Int] =
  if (digits.matches("[0-9]*")) Some(digits.toInt) else None

def deOptionize[A, R](func: A => Option[R]) =
  (arg: A) => func(arg) match {
    case Some(thing) => thing
    case None => throw new Exception("Result was empty")
  }

val noOption = deOptionize[String, Int](parseDigits)
noOption("10")
noOption("hello")
