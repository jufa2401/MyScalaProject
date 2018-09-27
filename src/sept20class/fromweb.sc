val numSet = Set(1, 2, 3, 4, 5, 6, 3, 7, 8, 9)
val numSeq = Seq(1, 2, 3, 4, 5, 6, 3, 7, 8, 9)
val numMap = Map("one"->1, "two"->2, "three"->3)
numMap.size
numSeq.size

numSet(3)
numSeq(3)
numMap("two")

numSet.foreach(println _)

numMap.foreach(println _)
for(i <- numMap) println(i)

var it = numSet.iterator
it.next
it.next
it.hasNext

val numSeq2 = numSeq.filter((x: Int)=>x%2 == 0)

numSeq2
numSeq

val numSet2 = numSet.map((x: Int)=>x * x)
numSet2
numSet


numSet.reduce((x:Int,y:Int) => x+y)
numSet.sum



val names = collection.mutable.Set("James")
names += "Hazel"
names += "Soupie"
// will return error
names += "James"
// will remove the existing james
names -= "James"
val nums = collection.mutable.Buffer(0, 1)
nums += 2
nums += 0
nums -= 0

val scores = collection.mutable.Map[String, Int]()
scores += "Carl"->100
scores += "Wendy"-> 88
scores("Wendy")
scores

val fibs = 1::1::2::3::5::Nil
val fibs2 = 4::fibs