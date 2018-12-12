
val l1 = List(1,2)
val l2 = List(3,4)

l1.zip(l2)




// problem 1
def zip[S, T](list1: List[S], list2: List[T]): List[(S, T)] = {
  if (list1.size != list2.size) throw new Exception("Lists must have same sizes")
  if (list1 == Nil) Nil
  else {
    val pairs = zip(list1.tail, list2.tail)
    (list1.head, list2.head):: pairs
  }
}

zip(l1,l2)



def pipe[S,T](f: S =>T, g: S=>T): S => T = {
  def helper(s: S): T = {
    try {
      f(s)
    } catch {
      case e: Exception => g(s)
    }
  }
  helper
}
val toInteger = pipe((s: String) => s.toInt, (s: String) => 0)
toInteger("12345")
toInteger("123x45")

def maxPal(word: List[String])= {
  val s = word.filter(word => word==word.reverse).map(_.length)
  if(s !=Nil) s.max
  else 0
}
maxPal(List("ala"))

