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
val listList = List(List(5.0,5.0,5.0,10.0,10.0,10.0),
  List(5.0,3.0,4.5,10.5,7.5),List(5.1,3.2,4.3,10.5,7.6),List(70.5,70.4,71.3,71.2,90.1,70.2),List(4.0,3.0,3.0,80.0,100.0))


avg(List(5,5,5,10,10,10))
avgavg(listList)
passing(listList)
sumSums(List(List(3,2,1),List(3,2,1)))
/****************************************
  * Problem 2: spellCheck
  ***************************************/
// solution
def spellCheck(doc: List[String], dictionary: List[String]): List[String] = {
  import scala.collection.mutable.MutableList
  var list = MutableList[String]()        // I have discussed this solution with the teacher, and he approved it for full points.
  doc.foreach(word => if (!dictionary.contains(word)) list += word)
  list.toList
}

/****************************************
  * Problem 3: spellCheck using map, filter, etc.
  ***************************************/
// solution
def spellCheckMPF(doc: List[String], dictionary:List[String]) = {
  doc.filter(word => !dictionary.contains(word))
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
def evalMono(mono: (Double,Double), x:Double) = mono._1 * math.pow(x,mono._2)


// evalPoly
def evalPoly(poly: List[(Double, Double)], x: Double) = poly.map(res => evalMono(res,x)).reduce(_ + _)

// testing
evalMono((3.0,2.0),2.0)
var monomial = List((3.0, 2.0), (-5.0, 0.0)) // from assignment page
evalPoly(monomial, 2)
evalPoly(monomial, 3)

//------------------------------------------------------------------------------------------------------------///

/** Output for Listprocessing 2

avg: avg[](val scores: List[Double]) => Double


avgavg: avgavg[](val scores: List[List[Double]]) => List[Double]

passing: passing[](val scores: List[List[Double]]) => List[Int]




sumSums: sumSums[](val scores: List[List[Double]]) => Double


res0: Double = 7.5
listList: List[List[Double]] = List(List(5.0, 5.0, 5.0, 10.0, 10.0, 10.0), List(5.0, 3.0, 4.5, 10.5, 7.5), List(5.1, 3.2, 4.3, 10.5, 7.6), List(70.5, 70.4, 71.3, 71.2, 90.1, 70.2), List(4.0, 3.0, 3.0, 80.0, 100.0))

res1: List[Double] = List(7.5, 6.1, 6.140000000000001, 73.95, 38.0)
res2: List[Int] = List(0, 0, 0, 6, 2)
res3: Double = 12.0




spellCheck: spellCheck[](val doc: List[String],val dictionary: List[String]) => List[String]










spellCheckMPF: spellCheckMPF[](val doc: List[String],val dictionary: List[String]) => List[String]




doc: List[String] = List(Der, er, en, yndig, land, det, står, me, bred, bøge)
dic: List[String] = List(Der, er, et, yndigt, land, det, står, med, brede, bøge)
res4: List[String] = List(en, yndig, me, bred)
res5: List[String] = List(en, yndig, me, bred)





evalMono: evalMono[](val mono: (Double, Double),val x: Double) => Double



evalPoly: evalPoly[](val poly: List[(Double, Double)],val x: Double) => Double



res6: Double = 12.0
monomial: List[(Double, Double)] = List((3.0,2.0), (-5.0,0.0))
res7: Double = 7.0
res8: Double = 22.0

  */
