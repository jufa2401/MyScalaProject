/******************************************
  *
Below is HW for Combinators
  *
  ******************************************/

// 1. Problem
def compose[X](f:X=>X, g:X=>X):X=> X=(x:X) => f(g(x))
// 2. Problem
def selfIter[T](f: T=> T, n: Int): T => T = {
  if(n == 1) f
  else compose(f,selfIter(f,n-1))
}

def inc(x: Double) = x + 1
def double(x: Double) = 2 * x
selfIter(inc, 10)(22)

// 3. Problem
def countPass[T](testArray: T => Boolean, p: Array[T]):Int = p.count(testArray)

countPass((x: Float) => x.isWhole(), Array(5.0f, 10.0f, 16.4f, 25.3f, 33.3f))

// 4. Problem
def recur(baseVal: Int, combiner: (Int,Int) => Int): Int => Int = {
  def helper(n:Int): Int = {
    if(n == 0) baseVal
    else combiner(n,helper(n-1))
  }
  helper
}

val recurVal = recur(1, (a: Int, b: Int) => a * b)
recurVal(4)

// same thing as above, but not assigned to a value
recur(1, (a: Int, b: Int) => a * b)(3) // factorial


def parseDigits(digits: String): Option[Int] =
  if (digits.matches("[0-9]*")) Some(digits.toInt) else None

//Takes function with an argument if the function returns none, this will throw an exception
def deOptionize[A, F](optionFunc: A => Option[F]) =
  (arg: A) => optionFunc(arg) match {
    case Some(thing) => thing
    case None => throw new Exception("Result of parent function was None    ")
  }

val noOption = deOptionize[String, Int](parseDigits)
noOption("10")
noOption("hello")
/******************************************
  *
Below is Output for Combinators
  *
  ******************************************/

//compose: compose[X](val f: X => X,val g: X => X) => X => X
//
//
//selfIter: selfIter[T](val f: T => T,val n: Int) => T => T
//
//
//
//
//inc: inc[](val x: Double) => Double
//double: double[](val x: Double) => Double
//res0: Double = 32.0
//
//
//countPass: countPass[T](val testArray: T => Boolean,val p: Array[T]) => Int
//res1: Int = 2
//
//
//recur: recur[](val baseVal: Int,val combiner: (Int, Int) => Int) => Int => Int
//
//
//
//
//
//
//
//recurVal: Int => Int = hw3.A$A22$A$A22$$Lambda$1654/2106322288@3744f7d0
//res2: Int = 24
//
//
//res3: Int = 6
//
//
//parseDigits: parseDigits[](val digits: String) => Option[Int]
//
//
//
//deOptionize: deOptionize[A,F](val optionFunc: A => Option[F]) => A => F
//
//
//
//
//
//noOption: String => Int = hw3.A$A22$A$A22$$Lambda$1657/1130277783@43c0a92
//  res4: Int = 10
//java.lang.Exception: Result of parent function was None
//  at hw3.A$A22$A$A22.$anonfun$deOptionize$1(session.sc:47)
//at #worksheet#.#worksheet#(session.sc:52)
