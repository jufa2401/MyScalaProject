package hw3.notes

object HowToDebugNoob extends App {
  def square(x: Int) = x * x
  def compose[T](f:T=>T, g:T=>T):T=> T=(x:T) => f(g(x))
  def selfIter[T](f: T=> T, n: Int): T => T = {
    if(n == 1) f

    else compose(f,selfIter(f,n-1))
  }

  def square(x: Double) = x * x
  def iterSquare(init: Double, n: Int) = {
    var result = init
    for(i <- 0 to n) result = square(result)
    result
  }

println(iterSquare(2,1))

  // 6. Problem
  def iterF[T](f: T => T, init: T, n: Int) = {
    var result = init
    for(i <- 0 to n) result = f(result)
    result

  }
  println(iterF(square,2,1))
  println(iterF(math.sin(_),3.14,4))
//  iterF(selfAppend,"Hello",4)


  // 4. Problem
  def recur(baseVal: Int, combiner: (Int,Int) => Int): Int => Int = {
    def helper(n:Int): Int = {
      if(n == 0) baseVal
      else combiner(n,helper(n-1))
    }
    helper
  }

  //cool shit
  recur(1, (a: Int, b: Int) => a * b)(3) // factorial

}
