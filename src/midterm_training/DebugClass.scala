package midterm_training

object DebugClass extends App {
  // problem 1
  def zip[S, T](list1: List[S], list2: List[T]): List[(S, T)] = {
    if (list1.size != list2.size) throw new Exception("Lists must have same sizes")
    if (list1 == Nil) Nil
    else {
      val pairs = zip(list1.tail, list2.tail)
      (list1.head, list2.head):: pairs
    }
  }
  def unzip[S, T](pairs: List[(S, T)]): (List[S], List[T]) = {
    if (pairs == Nil) (Nil, Nil)
    else {
      val pairsTail =unzip(pairs.tail)
      (pairs.head._1::pairsTail._1, pairs.head._2::pairsTail._2)
    }
  }                                               //> unzip: [S, T](pairs: List[(S, T)])(List[S], List[T])

  unzip(zip(List(1, 2, 3), List("one", "two", "three")))

  print(zip(List(1,2,4,5),List(3,4,5,6)))

}
