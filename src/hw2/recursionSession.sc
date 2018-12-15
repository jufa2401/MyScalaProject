
def inc(n: Int) = n + 1
def dec(n: Int) = n-1
def isZero(n: Int) = n == 0

// 1. Problem
def add(n: Int, m: Int): Int ={
  if(isZero(m)) n else inc(add(n,dec(m)))
}
add(5,10)


// 1. Problem as tailrecursive
def addTailRec(n: Int, m: Int): Int = {
  //  Decrements 1 from m until m is zero, then returns n
  if(isZero(m)) n else addTailRec(inc(n),dec(m))
}
addTailRec(5,10)
//TODO: def addtail = lambda(n,m) { if(m==0)n else addtail(n+1,m-1) }


// 2. Problem as tailrecursive
def mul_tailrec(n: Int, m: Int): Int = {
  def helper(n: Int, m: Int, count: Int): Int = {
    if(isZero(count)) n
    //      Adds n to n m times by decreasing count every time
    else helper(add(n,m),m,dec(count))
  }
  helper(0,n,m)
}
mul_tailrec(5,4)
mul_tailrec(3,4)
// 2. Problem regular recursion with interval
//mul(3,4)
//def mul(n: Int, m: Int): Int = {
//  if (n < m) mul(m, n)
//// Adds n to n, m-times by decreasing m everytime
//  else if (!isZero(m)) addTailRec(n,mul(n, dec(m)))
//  else 0
//}

// 3. Problem
def exp2(m:Int) : Int = {
  if(isZero(m)) inc(m)
  else mul_tailrec(2,exp2(dec(m)))
}
exp2(10)
exp2(11)
exp2(13)
exp2(14)

//TODO: def exp2 = lambda(m) { if(m == 0) m+1 else 2 * exp2(m-1) }

// 3. Problem TailRec problem
def exp2_tailrec(m: Int): Int = {
  def helper(m: Int, count: Int): Int = {
    if(isZero(count)) m
    else helper(mul_tailrec(2,m),dec(count))
  }
  if(isZero(m)) 1 else helper(1, m)
}
exp2_tailrec(10)
exp2_tailrec(11)
exp2_tailrec(13)
exp2_tailrec(14)

def hyperExp(n: Int): Int = if (isZero(n)) inc(n) else if (isZero(dec(n))) inc(n) else exp2(hyperExp(dec(n)))
// 4. Problem
hyperExp(0)
hyperExp(1)
hyperExp(2)
hyperExp(3)

//TODO: def hyperexp = lambda(n) { if (n ==0) n+1 else if (n-1==0) n+1 else exp2(hyperexp(n-1)) }

// another version with interval checking
//hyperExp_tailrec(0)
//hyperExp_tailrec(1)
//hyperExp_tailrec(2)
//hyperExp_tailrec(3)
//def hyperExp_tailrec(n: Int): Int = {
//  def helper(amount: Int, result: Int): Int =
//    if (n <= amount) result else helper(inc(amount), exp2(result))
//  if(isZero(n)) 1 else helper(0, 1)
//}

// 4. Problem as Tail Recursive
def hyperExp_tailrec2(n: Int): Int = {
  def helper(n: Int, count: Int): Int = {
    if(isZero(count))n
    else helper(exp2_tailrec(n),dec(count))
  }
  if(isZero(n)) 1 else helper(1,n)
}

hyperExp_tailrec2(0)
hyperExp_tailrec2(1)
hyperExp_tailrec2(2)
hyperExp_tailrec2(3)

/*
 5. Problem Doing tail recursion instead of regular recursion should remove the risk of running in to Stack Overflow problems if it is a good compiler.
 Since In tail recursion, you perform calculations first, then the recursive call, passing the results of the current step to the next recursive step.
 Tail Recursion should only help with space-complexity not time complexity, so computation should be the same, assuming you have infinite memory available
*/

// 9. Problem pt 1w
def fib(n: Int): Int = {
  if(isZero(n) || isZero(dec(n))) n else fib(dec(n)) + fib(dec(dec(n)))
}
fib(1)
fib(2)
fib(3)
fib(4)
fib(5)

// 9. Problem Tailrecursive
def fib_tailrec(n: Int) = {
  def helper(n: Int, a: Int, b: Int): Int =
  if (isZero(n)) a
  else if (isZero(dec(n))) b
  else helper(dec(n), b, addTailRec(a,b))

  helper(n, 0, 1)
}
fib_tailrec(1)
fib_tailrec(2)
fib_tailrec(3)
fib_tailrec(4)
fib_tailrec(5)



// 10. Problem Combinations calculator
def choose(n: Int, m: Int): Int = if (isZero(m)) inc(m) else mul_tailrec(n,choose(dec(n), dec(m))) / m
choose(10,  5)


