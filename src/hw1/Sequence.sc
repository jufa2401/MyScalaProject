tax(12300)                                  //> res0: Double = 0.0
tax(29000)                                  //> res1: Double = 1450.0
tax(125000)                                 //> res2: Double = 62500.0
tax(1000000)                                //> res3: Double = 500000.0
try {
  tax(-1000000)
} catch {
  case e: Exception => println(e)
}
// Problem 1
def tax(income: Double) = income match {
  case income: Double if income < 0 => throw new Exception("invalid income")

  case income: Double if income < 20000 => income*0.00
  case income: Double if income < 30000 => income*0.05
  case income: Double if income < 40000 => income*0.11
  case income: Double if income < 60000 => income*0.23
  case income: Double if income < 100000 => income*0.32
  case income: Double if income >= 100000 => income*0.50
}

// Problem 2
drawRectangle(3,4)
def drawRectangle(height: Int, length: Int) {
  for (i <- 0 to height*length){
    if(i>0 & i%length == 0) {
      println()
      if(i<height*length) print("*")
    }
    else {
      print("*")
    }
  }
}
//Problem 3
printSums(3,4)
def printSums(n:Int, m: Int) {

for(i <- 0 until n; j <- 0 until m) {
  println(""+i+" + " + j + " =" +(i+j))
}
//def printSums(n: Int, m: Int){}
}

// Problem 4
mystery()                                         //> i = 1
def mystery() {
  for (i <- 0 until 100) {
    if(i%3 != 0)
      if(i<10)println( "i = " +i)
  }
  println("done")
}



def below10(x: Double): Option[Double] = {
  if ( x <= 9)
  Some(x)
  else
  None
}
def root(x: Double): Option[Double] = {
  if (x < 0)
    None
  else
    Some(math.sqrt(x))
}

def pureBelow10(x: Option[Double]): Option[Double] = {
  x match {
    case None => None
    case Some(x) => below10(x)
  }
}

def pureRoot(x: Option[Double]): Option[Double] = {
  x match {
    case None => None
    case Some(x) => root(x)
  }
}

def below10root(x: Option[Double]): Option[Double] = {
  x match {
    case None => None
    case Some(x) => if (x <= 9) root(x) else None
  }
}
pureRoot(None)
pureRoot(Some(64))
pureRoot(Some(-64))
pureBelow10(Some(100))
pureBelow10(Some(-100))
pureBelow10(None)
below10root(Some(100))
below10root(Some(-100))
below10root(Some(9))
below10root(None)