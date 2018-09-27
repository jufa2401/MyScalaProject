// Assignment 4, List Processing I
// Name: Cyril Hottinger

/** **************************************
  * Problem 1: sum of odd cubes
  * **************************************/
// Iterative solution
def sumOfOddCubes_iterative(xs: List[Int]) = {
  var sum = 0
  xs.foreach {
    x => if (x % 2 != 0) sum += x * x
  }
  sum
}

// Recursive solution
def sumOfOddCubes_recursive(xs: List[Int]): Int =
  if (xs == Nil)
    0
  else
    (if (xs.head % 2 != 0) xs.head * xs.head else 0) + sumOfOddCubes_recursive(xs.tail)

// tail recursive solution
def sumOfOddCubes_tail_recursive(xs: List[Int], sum: Int = 0): Int =
  if (xs == Nil) sum
  else sumOfOddCubes_tail_recursive(xs.tail, sum + (if (xs.head % 2 != 0) xs.head * xs.head else 0))


// MPF solution
def sumOfOddCubes_functional(xs: List[Int]) =
  xs
    .filter(x => x % 2 != 0)
    .map(x => x * x)
    .sum // same as .reduce(_ + _), but more elegant

// testing
sumOfOddCubes_iterative(List(1, 2, 3, 4, 5))
sumOfOddCubes_recursive(List(1, 2, 3, 4, 5))
sumOfOddCubes_tail_recursive(List(1, 2, 3, 4, 5))
sumOfOddCubes_functional(List(1, 2, 3, 4, 5))

/** **************************************
  * Problem 2: sum of sums
  * **************************************/
// Iterative solution
def sumOfSums_iterative(xss: List[List[Int]]) = {
  var sum = 0
  xss.foreach {
    xs =>
      xs.foreach(
        x => sum += x
      )
  }
  sum
}

// Recursive solution
def sumOfSums_recursive(list: Any): Int =
  if (list == Nil)
    0
  else list match {
    case x: Int => x
    case xss: List[Any] => sumOfSums_recursive(xss.head) + sumOfSums_recursive(xss.tail)
  }


// tail recursive solution
def sumOfSums_tail_recursive(list: Any, sum: Int = 0): Int =
  if (list == Nil)
    0
  else list match {
    case x: Int => sum + x
    case xss: List[Any] => sumOfSums_tail_recursive(xss.head, sum + sumOfSums_tail_recursive(xss.tail))
  }


// MPF solution
def sumOfSums_functional(xss: List[List[Int]]) =
  xss
    .flatten
    .sum // same as .map(xs => xs.reduce(_ + _)).reduce(_ + _), but more elegant

// testing
sumOfSums_iterative(List(List(1, 2, 3), List(4, 5, 6)))
sumOfSums_recursive(List(List(1, 2, 3), List(4, 5, 6)))
sumOfSums_tail_recursive(List(List(1, 2, 3), List(4, 5, 6)))
sumOfSums_functional(List(List(1, 2, 3), List(4, 5, 6)))

/** **************************************
  * Problem 3: depth
  * **************************************/
// solution
def depth(v: Any): Int =
  v match {
    case Nil => 1
    case h :: t => math.max(depth(h), 1 + depth(t))
    case _ => 1
  }

// testing
depth(List(List(List(1, 2, List(3)))))
depth(Nil)
depth(7)


/** **************************************
  * Problem 6: numPass
  * **************************************/
def numPass_iterative[T](xs: List[T], predicate: T => Boolean) = {
  var sum = 0
  xs.foreach {
    x => if (predicate(x)) sum += 1
  }
  sum
}

// Recursive solution
def numPass_recursive[T](xs: List[T], predicate: T => Boolean): Int =
  if (xs == Nil)
    0
  else
    (if (predicate(xs.head)) 1 else 0) + numPass_recursive(xs.tail, predicate)

// tail recursive solution
def numPass_tail_recursive[T](xs: List[T], predicate: T => Boolean, sum: Int = 0): Int =
  if (xs == Nil)
    sum
  else
    numPass_tail_recursive(xs.tail, predicate, sum + (if (predicate(xs.head)) 1 else 0))

// MPF solution
def numPass_functional[T](xs: List[T], predicate: T => Boolean) =
  xs.count(predicate) // same as .filter(predicate).map(x => 1).reduce(_ + _), but more elegant

// testing
numPass_iterative[Int](List(1, 2, 3, 4, 5), x => x > 3)
numPass_recursive[Int](List(1, 2, 3, 4, 5), x => x > 3)
numPass_tail_recursive[Int](List(1, 2, 3, 4, 5), x => x > 3)
numPass_functional[Int](List(1, 2, 3, 4, 5), x => x > 3)

/** **************************************
  * Problem 7: allPass
  * **************************************/
def allPass_iterative[T](xs: List[T], predicate: T => Boolean) = {
  var every = true
  xs.foreach {
    x => every &= predicate(x)
  }
  every
}

// Recursive solution
def allPass_recursive[T](xs: List[T], predicate: T => Boolean): Boolean =
  if (xs == Nil)
  true
  else
    predicate(xs.head) && allPass_recursive(xs.tail, predicate)

// tail recursive solution
def allPass_tail_recursive[T](xs: List[T], predicate: T => Boolean, every: Boolean = true): Boolean =
  if (xs == Nil)
    every
  else
    allPass_tail_recursive(xs.tail, predicate, every && predicate(xs.head))

// MPF solution
def allPass_functional[T](xs: List[T], predicate: T => Boolean) =
  xs.forall(x => predicate(x)) // same as .filter(predicate).length == xs.length or .map(predicate).reduce(_ && _), but more elegant

// testing
allPass_iterative[Int](List(1, 2, 3, 4, 5), x => x > 3)
allPass_iterative[Int](List(1, 2, 3, 4, 5), x => x > 0)
allPass_recursive[Int](List(1, 2, 3, 4, 5), x => x > 3)
allPass_recursive[Int](List(1, 2, 3, 4, 5), x => x > 0)
allPass_tail_recursive[Int](List(1, 2, 3, 4, 5), x => x > 3)
allPass_tail_recursive[Int](List(1, 2, 3, 4, 5), x => x > 0)
allPass_functional[Int](List(1, 2, 3, 4, 5), x => x > 3)
allPass_functional[Int](List(1, 2, 3, 4, 5), x => x > 0)

/** **************************************
  * Problem 8: somePass
  * **************************************/
def some_iterative[T](xs: List[T], predicate: T => Boolean) = {
  var every = false
  xs.foreach {
    x => every |= predicate(x)
  }
  every
}

// Recursive solution
def some_recursive[T](xs: List[T], predicate: T => Boolean): Boolean =
  if (xs == Nil)
    false
  else
    predicate(xs.head) || some_recursive(xs.tail, predicate)

// tail recursive solution
def some_tail_recursive[T](xs: List[T], predicate: T => Boolean, every: Boolean = false): Boolean =
  if (xs == Nil)
    every
  else
    some_tail_recursive(xs.tail, predicate, every || predicate(xs.head))

// MPF solution
def some_functional[T](xs: List[T], predicate: T => Boolean) =
  xs.exists(predicate) // same as .filter(predicate).length > 0 or .map(predicate).reduce(_ || _), but more elegant

// testing
some_iterative[Int](List(1, 2, 3, 4, 5), x => x > 3)
some_iterative[Int](List(1, 2, 3, 4, 5), x => x > 10)
some_recursive[Int](List(1, 2, 3, 4, 5), x => x > 3)
some_recursive[Int](List(1, 2, 3, 4, 5), x => x > 10)
some_tail_recursive[Int](List(1, 2, 3, 4, 5), x => x > 3)
some_tail_recursive[Int](List(1, 2, 3, 4, 5), x => x > 10)
some_functional[Int](List(1, 2, 3, 4, 5), x => x > 3)
some_functional[Int](List(1, 2, 3, 4, 5), x => x > 10)

/** **************************************
  * Problem 10: isSorted
  * **************************************/
// solution
def isSorted[T](xs: List[T], ordering: Ordering[T]) =
  xs.sorted(ordering) == xs // generic solution just for fun :)


// testing
isSorted[Int](List(1, 2, 3, 4, 5), (x: Int, y: Int) => x.compareTo(y))
isSorted[Int](List(1, 2, 3, 5, 4), (x: Int, y: Int) => x.compareTo(y))

/** **************************************
  * Problem 13: streams
  * **************************************/
// ones

  val zero = Int(0) #:: Int(0)
  lazy val ones: Stream[Int] = Stream.continually(1)

  // nats
  lazy val nats: Stream[Int] = Stream.from(0)

  // evens
  lazy val evens: Stream[Int] = Stream.from(1).map(x => 2 * x)

  // squares
  lazy val squares: Stream[Int] = Stream.from(1).map(x => x * x)
