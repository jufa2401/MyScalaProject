import scala.util.control.TailCalls.TailRec
//Assignment 4, List Processing I
//Name: Justin Fabricius

// Helpers
val cube = (x: Int) => x*x*x
def isEven(x: Int) = x % 2 == 0
def isOdd(x: Int) = x % 2 != 0

/****************************************
  * Problem 1: sum of odd cubes
  ***************************************/

// Iterative solution
def sumOfOddCubeIte(list : List[Int]): Int = {
  var sum = 0
  for(element <- list){
    if(isOdd(element)) sum += cube(element)
  }
  sum
}

// Recursive solution
def sumOfOddCubeRec(list: List[Int]): Int = {
  if(list == Nil) 0
  else{
    if(isOdd(list.head)) cube(list.head) +sumOfOddCubeRec(list.tail)
    else sumOfOddCubeRec(list.tail)
  }
}

// tail recursive solution
def sumOfOddCubeTailRec(list:List[Int]): Int = {
  def helper(list:List[Int], sum: Int): Int = {
    if(list == Nil) sum
    else {
      val testIfOdd = if (isOdd(list.head)) cube(list.head) else 0
      helper(list.tail,sum+testIfOdd)
    }
  }
  helper(list,0)
}
// MPF solution
def sumOfOddMPF(list: List[Int]): Int = {
  val li = list.filter(isOdd).map(cube)
  if (li == Nil) 0
  else li.reduce(_ + _)
} //.reduce(_+_) is the same as .sum

// testing
val cubeList = List(2,5,3,5)
val cubeList2 = List(2,4,6)
sumOfOddCubeIte(cubeList)
sumOfOddCubeIte(cubeList2)
sumOfOddCubeRec(cubeList)
sumOfOddCubeRec(cubeList2)
sumOfOddCubeTailRec(cubeList)
sumOfOddCubeTailRec(cubeList2)
sumOfOddMPF(cubeList)
sumOfOddMPF(cubeList2)



/****************************************
  * Problem 2: sum of sums
  ***************************************/
// Iterative solution
def sumOfSumsIt(listList:List[List[Int]]): Int = {
  var sum = 0
  for(list <- listList){
    for (n <- list) {
      sum+=n
    }
  }
  sum
}
// Above for loop is the same as this:
// var sum = 0
// listList.foreach {
// list => list.foreach{
//     n => sum+=n
//   }
//  }
// sum

// Recursive solution
def sumOfSumsRec(list: List[List[Int]]): Int = {
  def helper(list: List[Int]): Int = {
    if (list == Nil) 0
    else list.head + helper(list.tail)
  }
  if (list == Nil) 0
  else
    helper(list.head) + sumOfSumsRec(list.tail)
}

// tail recursive solution

def sumOfSumsTailRec(list: List[List[Int]]): Int = {
  def sumTail(list: List[Int]): Int = {
    def sumHelper(result: Int, unseen: List[Int]): Int = {
      if (unseen == Nil)
        result
      else
        sumHelper(result + unseen.head, unseen.tail)
    }
    sumHelper(0, list)
  }
  def sumOfSumHelper(result: Int, unseen: List[List[Int]]): Int = {
    if (unseen == Nil)
      result
    else
      sumOfSumHelper(result + sumTail(unseen.head), unseen.tail)
  }
  sumOfSumHelper(0, list)
}

// MPF solution
def sumOfSumsReduce(list: List[List[Int]]) = list.flatten.reduce(_+_)

// testing
val list = List(List(1,2,3),List(4,5,6))
sumOfSumsIt(list)
sumOfSumsReduce(list)
sumOfSumsRec(list)
sumOfSumsTailRec(list)

/****************************************
  * Problem 3: depth
  ***************************************/
// solution
def depth(v: Any):Int = {
    v match {
      case Nil => 0
      case head :: tail => math.max(depth(head), 1 + depth(tail))
      case _ => 0
    }
}

// testing
depth(List(List(3,List(5))))
depth(Nil)

depth(420)

/****************************************
  * Problem 6: numPass
  ***************************************/

// Iterative solution
def numPassIte[T](list: List[T], testFunction: T => Boolean): Int = {
  var cnt = 0
  for (x <- list)
    if (testFunction(x)) cnt += 1
  cnt
}

// Recursive solution
def numPassRec[T](xs: List[T], predicate: T => Boolean): Int ={
  if (xs == Nil) 0
  else {
    val test = if (predicate(xs.head)) 1 else 0 //    Adds 1 if the testFunction is true
    numPassRec(xs.tail, predicate)+test
  }
}

// tail recursive solution
def numPassTailRec[T](list: List[T], testFunction: T => Boolean): Int = {
  def helper[T](list: List[T], testFunction:T => Boolean, cnt: Int): Int = {
    if (list == Nil) cnt
    else if (testFunction(list.head)) {
      helper(list.tail, testFunction, cnt + 1)
    }
    else {
      helper(list.tail, testFunction, cnt)
    }
  }
  helper(list,testFunction,0)
}
// MPF solution
def numPassMPF[T](list: List[T], testFunction: T => Boolean): Int = {
  list.filter(testFunction).size    // This is the same as using .count
}
// testing
val testlist = List(2,2,3,1,5,3,2)
numPassIte(testlist,isEven)
numPassRec(testlist,isEven)
numPassTailRec(testlist,isEven)
numPassMPF(testlist,isEven)
numPassMPF(testlist,isEven)
//numPassTail2(testlist,isEven)

/****************************************
  * Problem 7: allPass
  ***************************************/

// Iterative solution
def allPasIte[T](list:List[T], testFunction: T => Boolean): Boolean = {
  var li = list
  while (li.nonEmpty) {
    if (!testFunction(li.head)) return false
    li = li.tail
  }
  true
}
// ^same as list.forall(testFunction).forall is an iterative function


// Recursive solution REEEEEEEEEEEEEEEEE
def allPassRec[T](list: List[T], testFunction: T => Boolean): Boolean = {
  if(list == Nil) true
  else if(testFunction(list.head)) allPassRec(list.tail,testFunction)
  else {
    allPassRec(Nil,(d: Boolean) => false) // This is regular recursive, but it is stupid. But doing this function recursively is stupid anyway.
    false
  }
}

// tail recursive solution
def allPassTailRec[T](list: List[T], testFunction: T => Boolean) : Boolean = {
  if(list == Nil) true
  else if(testFunction(list.head)) allPassTailRec(list.tail,testFunction)
  else false
}
// MPF solution
def allPassMPF[T](list:List[T], testFunction: T => Boolean): Boolean = list.map(testFunction).reduce(_ && _) //forall is easier to read, but I am trying to comply with the assignment


// testing
allPasIte(testlist,isEven)
allPasIte(List(2,2,4),isEven)
allPasIte(List(2,3),isEven)
allPassTailRec(testlist,isEven)
allPassTailRec(List(2,2,4),isEven)
allPassTailRec(List(2,3),isEven)
allPassRec(testlist,isEven)
allPassRec(List(2,2,4),isEven)
allPassRec(List(2,3),isEven)
allPassMPF(testlist,isEven)
allPassMPF(List(2,2,4),isEven)
allPassMPF(List(2,3),isEven)


/****************************************
  * Problem 8: somePass
  ***************************************/
// Iterative solution
def somePassIte[T](list: List[T], testFunction: T => Boolean) : Boolean = {
  var li = list
  while (li.nonEmpty) {
    if (testFunction(li.head)) return true
    li = li.tail
  }
  false
}

//  recursive solution
def somePassRec[T](list: List[T], testFunction: T => Boolean) : Boolean = {
  if(list == Nil) false
  else if(testFunction(list.head)) true
  else {
    somePassRec(list.tail,testFunction)
    false
  }
}

// tail Recursive solution
def somePassTailRec[T](list: List[T], testFunction: T => Boolean) : Boolean = {
  if(list == Nil) false
  else if(testFunction(list.head)) true
  else somePassTailRec(list.tail,testFunction)
}

// MPF solution
def somePassMPF[T](list:List[T], testFunction: T => Boolean): Boolean = list.filter(testFunction).length > 0 // same as .exists

// testing
somePassIte(List(3,4),isOdd)
somePassIte(List(2,4),isOdd)
somePassMPF(List(3,4),isOdd)
somePassMPF(List(2,4),isOdd)
somePassTailRec(List(3,4),isOdd)
somePassTailRec(List(2,4),isOdd)

somePassIte(List(3,3), (x: Int) => x % 2 == 0)
/****************************************
  * Problem 10: isSorted
  ***************************************/
// solution

def isSorted(nums: List[Int]): Boolean =
  if (nums.size < 2)
    true
  else
    (nums.head <= nums(1)) && isSorted(nums.tail)
// testing
isSorted(List(5, 4, 3, 2, 1))
isSorted(List(1, 2, 3, 4, 5))

/****************************************
  * Problem 13: streams
  ***************************************/

// ones
val ones: Stream[Int] = 1 #:: ones
ones(10)
//val ones2: Stream[Int] = 1 #:: 1

// nats
val nats: Stream[Int] = {
  def loop(h: Int): Stream[Int] = h #:: loop(h+1)
  loop(0)
}
nats(100)
//val nats: Stream[Int] = Stream.from(0)

// evens
val evens:Stream[Int] = nats.map(x => 2*x)
evens(99)
//val evens: Stream[Int] = Stream.from(1).map(x => 2 * x)

// squares
val squares: Stream[Int] = nats.map(x => x*x)
squares(100)
//val squares2: Stream[Int] = Stream.from(1).map(x => x * x)


//-----------------------------------------------------------------///

/** Output for listprocessing
  *




cube: Int => Int = hw4.A$A31$A$A31$$Lambda$1964/700121954@1b665d9
isEven: isEven[](val x: Int) => Boolean
isOdd: isOdd[](val x: Int) => Boolean






sumOfOddCubeIte: sumOfOddCubeIte[](val list: List[Int]) => Int








sumOfOddCubeRec: sumOfOddCubeRec[](val list: List[Int]) => Int








sumOfOddCubeTailRec: sumOfOddCubeTailRec[](val list: List[Int]) => Int










sumOfOddMPF: sumOfOddMPF[](val list: List[Int]) => Int






cubeList: List[Int] = List(2, 5, 3, 5)
cubeList2: List[Int] = List(2, 4, 6)
res0: Int = 277
res1: Int = 0
res2: Int = 277
res3: Int = 0
res4: Int = 277
res5: Int = 0
res6: Int = 277
res7: Int = 0





sumOfSumsIt: sumOfSumsIt[](val listList: List[List[Int]]) => Int






















sumOfSumsRec: sumOfSumsRec[](val list: List[List[Int]]) => Int











sumOfSumsTailRec: sumOfSumsTailRec[](val list: List[List[Int]]) => Int



















sumOfSumsReduce: sumOfSumsReduce[](val list: List[List[Int]]) => Int


list: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
res8: Int = 21
res9: Int = 21
res10: Int = 21
res11: Int = 21





depth: depth[](val v: Any) => Int








res12: Int = 2
res13: Int = 0

res14: Int = 0






numPassIte: numPassIte[T](val list: List[T],val testFunction: T => Boolean) => Int







numPassRec: numPassRec[T](val xs: List[T],val predicate: T => Boolean) => Int








numPassTailRec: numPassTailRec[T](val list: List[T],val testFunction: T => Boolean) => Int












numPassMPF: numPassMPF[T](val list: List[T],val testFunction: T => Boolean) => Int



testlist: List[Int] = List(2, 2, 3, 1, 5, 3, 2)
res15: Int = 3
res16: Int = 3
res17: Int = 3
res18: Int = 3
res19: Int = 3







allPasIte: allPasIte[T](val list: List[T],val testFunction: T => Boolean) => Boolean












allPassRec: allPassRec[T](val list: List[T],val testFunction: T => Boolean) => Boolean









allPassTailRec: allPassTailRec[T](val list: List[T],val testFunction: T => Boolean) => Boolean





allPassMPF: allPassMPF[T](val list: List[T],val testFunction: T => Boolean) => Boolean



res20: Boolean = false
res21: Boolean = true
res22: Boolean = false
res23: Boolean = false
res24: Boolean = true
res25: Boolean = false
res26: Boolean = false
res27: Boolean = true
res28: Boolean = false
res29: Boolean = false
res30: Boolean = true
res31: Boolean = false






somePassIte: somePassIte[T](val list: List[T],val testFunction: T => Boolean) => Boolean









somePassRec: somePassRec[T](val list: List[T],val testFunction: T => Boolean) => Boolean









somePassTailRec: somePassTailRec[T](val list: List[T],val testFunction: T => Boolean) => Boolean






somePassMPF: somePassMPF[T](val list: List[T],val testFunction: T => Boolean) => Boolean


res32: Boolean = true
res33: Boolean = false
res34: Boolean = true
res35: Boolean = false
res36: Boolean = true
res37: Boolean = false






isSorted: isSorted[](val nums: List[Int]) => Boolean





res38: Boolean = false
res39: Boolean = true






ones: Stream[Int] = Stream(1, ?)
res40: Int = 1



nats: Stream[Int] = Stream(0, ?)



res41: Int = 100



evens: Stream[Int] = Stream(0, ?)
res42: Int = 198



squares: Stream[Int] = Stream(0, ?)
res43: Int = 10000

  */
