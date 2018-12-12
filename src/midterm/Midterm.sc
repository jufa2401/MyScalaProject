/**
  * Name: Justin Sven Fabricius
  * CS152 Section 1 Programming Paradigms Midterm
  **/

/* Problem 1 */

def addPositives(list: List[Option[Int]]): Int = {
  def isPositive(x: Option[Int]): Boolean = {
    x match {
      case Some(num) => num > 0
      case None => false
    }
  }
  def mapToInts(x: Option[Int]): Int = {
    x match {
      case Some(num) => num
      case None => 0
    }
  }
  list.filter(isPositive).map(mapToInts).sum
}

addPositives(List(Some(3), None, Some(4), Some(-5)))


/* Problem 2 */
object accumulator {
  var accum: Int = 0
  def execute(program: Command*) = {
    accum = 0
    program.foreach(cmmd => cmmd.execute()) // updates accum
    accum
  }
}

trait Command {
  def execute()
}

class Add(val value: Int) extends Command {
  def execute(): Unit = {
    accumulator.accum += value
  }
}
object Add {
  def apply(value: Int) = new Add(value)
}

class Set(val value: Int = 0) extends Command {
  def execute(): Unit = {
    accumulator.accum = value
  }
}

object Set {
  def apply(value: Int) = new Set(value)
}
/* Problem 2.2 */
class Iter(val program: Command, val value: Int) extends Command {
  def execute(): Unit = {
    (0 until value).foreach(_ => program.execute())
  }
}

object Iter {
  def apply(program: Command, value: Int) = {
    new Iter(program, value)
  }
}

accumulator.execute(Set(2), Add(3), Iter(Add(2), 5))

/* Problem 3 */

def applyFilters[T](listType: List[T], tests: List[T => Boolean]): List[T] = {
    var list = listType
  tests.foreach(test => list = list.filter(test))
  list
}


val myTests = List((x: Int) => x % 2 == 0, (x: Int) => x > 10, (x: Int) => x < 50) // my tests
applyFilters(List(7, 8, 12, 15, 20, 52), myTests)
