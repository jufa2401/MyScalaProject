import scala.collection.mutable
// Assignment 4, List Processing II
// Name: Cyril Hottinger

/** **************************************
  * Problem 1: score processing
  * **************************************/

// avg
def avg(scores: List[Double]) = scores.sum / scores.length

// avgAvg
def avgAvg(scores: List[List[Double]]) = scores.map(avg)

// passing
def passing(scores: List[List[Double]]) = scores.map(score => score.count(avg => avg > 70))

// sumSums
def sumSums(scores: List[List[Double]]) = scores.flatten.sum

// testing
var cs152 = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 68.0), List(88.0, 82.0, 78.0))
avg(cs152(1))
avgAvg(cs152)
passing(cs152)
sumSums(cs152)

/** **************************************
  * Problem 2: spellCheck iterative solution
  * **************************************/
// solution
def spellCheck_iter(doc: List[String], dictionary: List[String]) = {
  var list = mutable.MutableList[String]()
  doc.foreach(word => if (!dictionary.contains(word)) list += word)
  list.toList
}

// testing
spellCheck_iter(List("This", "si", "my", "test", "docment"), List("This", "is", "my", "test", "document"))


/** **************************************
  * Problem 3: spellCheck using map, filter, etc.
  * **************************************/
// solution
def spellCheck(doc: List[String], dictionary: List[String]) = doc.filter(word => !dictionary.contains(word))

// testing
spellCheck(List("This", "si", "my", "test", "docment"), List("This", "is", "my", "test", "document"))

/** **************************************
  * Problem 4: polynomials
  * **************************************/

// evalMono
def evalPoly(poly: List[(Double, Double)], x: Double) =
  poly.map(monomial => evalMono(monomial, x)).sum

// evalPoly

def evalMono(monomial: (Double, Double), x: Double) =
  monomial match {
    case (op, exp) => op * math.pow(x, exp)
  }

// testing
var monomial = List((3.0, 2.0), (-5.0, 0.0))

evalPoly(monomial, 1)
evalPoly(monomial, 2)
evalMono((3.0,2.0),2.0)