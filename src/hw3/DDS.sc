
/******************************************
  *
Below is HW for Discrete Dynamical Systems
  *
  ******************************************/

// 1. Problem
def controlLoop[S](state: S, cycle: Int, halt: (S,Int)=> Boolean, update: (S, Int) => S): S = {
  //  Checks if halted, then returns state
  if(halt(state,cycle)) state
  //   Otherwise it updates state, then we update cycle by incrementing with 1. Then we update and go back into the controlloop with new values
  else controlLoop(update(state,cycle),cycle+1,halt,update)
}
// 2. Problem
controlLoop[Int](1,0,
  (population: Int, cycle: Int) => population >= 100000,
  (pop: Int, cycle: Int) => pop * 2)

// 3. Problem from In class example
def solve(f: Double=> Double) = {
  val delta = 1e-10
  def deriv(f:Double => Double) = {
    def df(x: Double) = (f(x+delta) - f(x))/delta
    df _
  }
  def df = deriv(f)
  def goodEnough = (guess: Double, cycle: Int) => math.abs(f(guess)) <= delta
  def improve = (guess: Double, cycle: Int) => guess - f(guess) / df(guess)
  controlLoop(1.0, 0 ,goodEnough, improve)
}

// 4. Problem
def squareRoot(x: Double) = solve((y: Double) => y*y-x)
squareRoot(9)

// 5. Problem
def cubicRoot(x: Double) = solve((y: Double) => y*y*y-x)
cubicRoot(9)
// 6. Problem
def nthRoot(x: Double, n: Int) = solve((y: Double) => math.pow(y,n)-x)
nthRoot(9,3)

// 7. Problem
val numperiods = 365*24*60*60
def value (count: Int, currentVal: Double): Double = {
  if(count == numperiods) currentVal
  else value(count+1,currentVal+currentVal*1.0/numperiods)
}
value(0,1.0)


/******************************************
  *
Below is Ouput for DDS
  *
  ******************************************/
//
//
//
//
//controlLoop: controlLoop[S](val state: S,val cycle: Int,val halt: (S, Int) => Boolean,val update: (S, Int) => S) => S
//
//
//
//
//
//
//
//res0: Int = 131072
//
//
//
//
//solve: solve[](val f: Double => Double) => Double
//
//
//
//
//
//
//
//
//
//
//
//
//squareRoot: squareRoot[](val x: Double) => Double
//res1: Double = 3.0
//
//
//cubicRoot: cubicRoot[](val x: Double) => Double
//res2: Double = 2.0800838230519036
//
//nthRoot: nthRoot[](val x: Double,val n: Int) => Double
//res3: Double = 2.080083823051904
//
//
//numperiods: Int = 31536000
//value: value[](val count: Int,val currentVal: Double) => Double
//
//
//
//res4: Double = 2.7182817853606362

