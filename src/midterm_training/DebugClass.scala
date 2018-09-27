package midterm_training

object DebugClass extends App {
  def map2[T, S, U](list1: List[S], list2: List[T], combiner: (S, T)=>U): List[U] = {
    if(list1.size != list2.size) throw new Exception("Lists must be of equal size")
    if(list1 == Nil) Nil
    else {
      println(combiner(list1.head,list2.head))
      combiner(list1.head,list2.head)::map2(list1.tail,list2.tail,combiner)
    }
  }

  map2(List(2, 3, 4), List(6, 7, 8), (x: Int, y: Int) => x + y)
}
