
class Number(val value: Int) { override def toString = "Number(" + value + ")" }

def lift(intToInt: Int => Int): Number => Number = {
  def r(v: Number) = new Number(intToInt(v.value))
  r
}
val numSquare = lift((n: Int) => n * n)
numSquare(new Number(7))

// maps and combines 2 lists based on the argument combiner function
def map2[T, S, U](list1: List[S], list2: List[T], combiner: (S, T) => U): List[U] = {
  if(list1.size != list2.size) throw new Exception("Lists must be of equal size")
  else if(list1 == Nil) Nil
  else {
    println(combiner(list1.head,list2.head))
    combiner(list1.head,list2.head)::map2(list1.tail, list2.tail, combiner)
  }
}

map2(List(2, 3, 4), List(6, 7, 8), (x: Int, y: Int) => x + y)




val list1 = List(1,2)
val list2 = List(3,4)
list1::list2
list1+:list2
list1:::list2



