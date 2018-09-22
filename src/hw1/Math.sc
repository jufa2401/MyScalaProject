import math.{pow, sqrt}
import scala.util.Random

solve(2,-2,-4)
solve(1, 0, 1)
solve(1, 0, -1)

def solve(A: Int, B: Int, C: Int):Option[(Double, Double)] = {
  if (A == 0) None
  else {
    def D = B * B - 4 * A * C
    if (D == 0) Some(-B / 2.0 / A, 0.00)
    else if (D > 0){ Some(((-B + sqrt(D)) / 2.0 / A, (-B - sqrt(D)) / 2.0 / A))}
    else None
  }
}

class Point(val x: Double, val y: Double) {
  def dist(point: Point): Double =
    sqrt(pow(x - point.x, 2) + pow(y - point.y, 2))
}
new Point(1,1).dist(new Point(0,0))
new Point(3,0).dist(new Point(0,0))


class Vector3d(val x: Double, val y: Double, val z: Double){
  def dotProd(vec: Vector3d): Double = {
    x * vec.x + y * vec.y + z * vec.z
  }
}
new Vector3d(2.0,3,4).dotProd(new Vector3d(2,2.0,2))


def force(m1: Double, m2 :Double, d:Double): Double ={
  9.82*((m1*m2)/pow(d,2))
}

def mean(array: Array[Double]): Double = {
  var total = 0.00
  for (i <- array.indices){
    total += array(i)
  }
  total/array.length
}
def stddev(array: Array[Double]): Double = {
  var total = 0.00
  val lmean = mean(array)
  for (i <- array.indices){
    total += pow(array(i)-lmean,2)
  }
  sqrt(total/array.length)
}
mean(Array(2.0,3.0,4.0,5.0))
stddev(Array(2.0,3.0,4.0,5.0))


isPrime(0)
isPrime(1)
isPrime(2)
isPrime(8)
try {
  isPrime(-1)
} catch {
  case exception: Exception => print(exception)
}

def isPrime(input :Int)= {
  if (input < 0) throw new Exception("Input cannot be negative")
  else if (input < 2) false
  else if (input == 2) true
  else !(2 until input).exists(x => input % x == 0)
}

def gcd(a: Int, b:Int):Int = {
  if (a == 0) b
  else gcd(b % a, a)
}

def phi(n:Int)= {
  var counter = 1
  for (i <- 2 to n) {
    if (gcd(i, n) == 1)
      counter += 1
  }
  counter
}

phi(9)
phi(10)

rollDice()
def rollDice():(Int, Int) = {
  //  Putting in time as a parameter should give the Random class a new seed so that it does not repeat rolls when interpreter is restarted
  val random = new Random(System.currentTimeMillis)
  //  +1 so that you dont roll 0
  (random.nextInt(6)+1, random.nextInt(6)+1)
}
