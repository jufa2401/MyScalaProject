
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
def sumOfOddCubeIte(list : List[Int]): Int ={
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
/**
  * hmm
  * @param listList
  * @return
  */
// Recursive solution
def sumOfSumsRec(listList: List[List[Int]]): Int = {
  val newlist = listList.flatten
  newlist match {
    case head :: tail => head + sumOfSumsRec(List(newlist.tail)) // if there is an element, add it to the sum of the tail
    case Nil => 0 // if there are no elements, then the sum is 0
  }
}
// tail recursive solution IS FLATTEN LEGAL?
def sumOfSumsTailRec(listList: List[List[Int]]): Int = {
  def helper(listList: List[List[Int]], sum: Int): Int = {
    val newlist = listList.flatten
    newlist match {
      case x :: tail => helper(List(newlist.tail), sum + x)
      case Nil => sum
    }
  }
  helper(listList, 0)
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
def numPassIte[T](list: List[T],testFunction: T => Boolean): Int = {
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
def allPasIte[T](list:List[T],testFunction: T => Boolean): Boolean = {
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
    allPassRec(Nil,(d: Boolean) =>false) // This is regular recursive, but it is stupid. But doing this function recursively is stupid anyway.
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

/****************************************
  * Problem 10: isSorted
  ***************************************/
// solution
def isSorted[T](list: List[T], ordering: Ordering[T]) = list.sorted(ordering) == list
isSorted[Int](List(5, 4, 3, 2, 1), (x: Int, y: Int) => x.compareTo(y))
isSorted[Int](List(1, 2, 3, 4, 5), (x: Int, y: Int) => x.compareTo(y))



// testing

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
//val nats: Stream[Int] = Stream.from(0)

// evens
val evens:Stream[Int] = nats.map(x=> 2*x)
evens(99)
//val evens: Stream[Int] = Stream.from(1).map(x => 2 * x)

// squares
val squares: Stream[Int] = nats.map(x=> x*x)
squares(100)
//val squares2: Stream[Int] = Stream.from(1).map(x => x * x)


