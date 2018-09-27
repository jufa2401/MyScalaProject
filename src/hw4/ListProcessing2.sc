//Assignment 4, List Processing II
//Name: Justin Sven Fabricius

/****************************************
  * Problem 1: score processing
  ***************************************/
// avg
def avg(scores: List[Double]) = scores.sum/scores.size

// avgAvg
def avgavg(scores: List[List[Double]]) = scores.map(avg) //convenient having avg function from before
// passing
def passing(scores: List[List[Double]]) = {
  scores.map(score => score.count(avg => avg > 70)) // computes how many passing grades each individual student has
}

// sumSums
def sumSums(scores:List[List[Double]]) = scores.flatten.sum // sum is same as .reduce(_ + _)

// testing
avg(List(5,5,5,10,10,10))
val listList = List(List(5.0,5.0,5.0,10.0,10.0,10.0),
  List(5.0,3.0,4.5,10.5,7.5),List(5.1,3.2,4.3,10.5,7.6),List(70.5,70.4,71.3,71.2,90.1,70.2),List(4.0,3.0,3.0,80.0,100.0))
avgavg(listList)
passing(listList)
sumSums(List(List(3,2,1),List(3,2,1)))
/****************************************
  * Problem 2: spellCheck
  ***************************************/
// solution
def spellCheck(doc: List[String], dictionary: List[String]): List[String] = {
  import scala.collection.mutable.MutableList
  var list = MutableList[String]()
  doc.foreach(word => if (!dictionary.contains(word)) list += word)
  list.toList
}

/****************************************
  * Problem 3: spellCheck using map, filter, etc.
  ***************************************/
// solution
def spellCheckMPF(doc: List[String], dictionary:List[String]) = {
  doc.filter(word => !dictionary.contains(word))
//  doc.map(word => if(!dictionary.contains(word)) doc.
}
// testing
val doc = List("Der", "er", "en", "yndig", "land","det","står","me","bred","bøge")
val dic = List("Der", "er", "et", "yndigt", "land","det","står","med","brede","bøge")
spellCheck(doc,dic)
spellCheckMPF(doc,dic)

/****************************************
  * Problem 4: polynomials
  ***************************************/
// evalMono
def evalMono(mono: (Double,Double), x:Double) = mono._1*math.pow(x,mono._2)


// evalPoly
def evalPoly(poly: List[(Double, Double)], x: Double) = poly.map(res => evalMono(res,x)).reduce(_ + _)


// testing
evalMono((3.0,2.0),2.0)
var monomial = List((3.0, 2.0), (-5.0, 0.0)) // from assignment page
evalPoly(monomial, 2)
evalPoly(monomial, 3)
