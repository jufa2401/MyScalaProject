
def isEven(x: Int) = x % 2 == 0
def isOdd(x: Int) = x % 2 != 0


// With filter, map and reduce

def max(xs: List[List[Int]]): Option[List[Int]] = xs match {
  case Nil => None
  case List(x: List[Int]) => Some(x)
}
def max2(i: List[List[Int]]) : Double = {
  if (i == Nil)
    0.0
  else {
    if (max2(i.tail) > i.head.max)
      max2(i.tail)
    else
      i.head.max
  }
}

//def oddCubeAddFMR(list: List[Int]): Int = list.filter(isOdd).map(cube).reduce(_ + _)


//  list.filter(isOdd).map(cube).reduce(_ + _)


//Assignment 4, List Processing I
//Name: Justin Fabricius

/****************************************
  * Problem 1: sum of odd cubes
  ***************************************/
// Iterative solution
def oddCubeAddIt(list : List[Int]): Int ={
  var sum = 0
  if (list == Nil) 0
  else {
    for(i <- list.filter(isOdd)){
      sum += i * i * i}
  }
  sum
}

// Recursive solution
val cube = (x: Int) => x*x*x

def oddCubeRec(list: List[Int]): Int = {
  val fList = list.filter(isOdd)
  if(list == Nil) 0
  else cube(fList.head)+oddCubeRec(fList.tail)
}


// tail recursive solution
def oddCubeTailRec(list: List[Int]): Int = {
  def helper(sum: Int, list: List[Int]): Int = {
    if (list == Nil) sum
    else {
      val head = list.head
      helper(head*head*head+sum, list.tail)
    }
  }
  helper(0,list.filter(isOdd))
}
// MPF solution
def oddCubeAddMPF(list: List[Int]): Int = list.filter(isOdd).map(cube).reduce(_ + _)

// testing
val li = List(2,5,3,5)
oddCubeAddIt(li)
oddCubeRec(li)
oddCubeTailRec(li)
oddCubeAddMPF(li)

/****************************************
  * Problem 2: sum of sums
  ***************************************/
// Iterative solution
def sumIt(listList:List[List[Int]]): Int = {
  var sum = 0
  listList.flatten.foreach(sum+= _) // For each iterates over a list
  sum
}

// Recursive solution
def recsum(listList: List[List[Int]]): Int = {
  val newlist = listList.flatten
  newlist match {
    case x :: tail => x + recsum(List(newlist.tail)) // if there is an element, add it to the sum of the tail
    case Nil => 0 // if there are no elements, then the sum is 0
  }
}
// tail recursive solution
def tailsum(listList: List[List[Int]]): Int = {
  def helper(listList: List[List[Int]], accum: Int): Int = {
    val newlist = listList.flatten
    newlist match {
      case x :: tail => helper(List(newlist.tail), accum + x)
      case Nil => accum
    }
  }
  helper(listList, 0)
}

// MPF solution
def sumReduce(list: List[List[Int]]) = list.flatten.reduce(_+_)

// testing
val list = List(List(1,2,1),List(2,4,1))
sumIt(list)
sumReduce(list)
recsum(list)
tailsum(list)



/****************************************
  * Problem 3: depth
  ***************************************/
// solution
def depth(value: Any):Int = value match {
  case first::rest => {
    0
  }
}


// testing

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
//def numPassRec[T](list: List[T], testFunction: T => Boolean): Int = {
//  if(list == Nil) throw new Exception("Invalid list")
//  else if(testFunction(list.head)) numPassRec(list.tail,testFunction)
//  else 0
//}

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
def numPassMFF[T](list: List[T], testFunction: T => Boolean): Int = {
  list.filter(testFunction).size    // This is the same as using .count
}
// testing
val testlist = List(2,2,3,1,5,3,2)
numPassMFF(testlist,isEven)
numPassTailRec(testlist,isEven)
numPassIte(testlist,isEven)
//numPassTail2(testlist,isEven)

/****************************************
  * Problem 7: allPass
  ***************************************/
// Iterative solution

// Recursive solution

// tail recursive solution

// MPF solution

// testing

/****************************************
  * Problem 8: somePass
  ***************************************/
// Iterative solution

// Recursive solution

// tail recursive solution

// MPF solution

// testing

/****************************************
  * Problem 10: isSorted
  ***************************************/
// solution

// testing

/****************************************
  * Problem 13: streams
  ***************************************/
// ones

// nats

// evens

// squares





