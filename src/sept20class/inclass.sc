
case class Note(amplitude: Double, frequency: Double, duration: Double = 1.0)

val symphony1 = List(Note(3,30,3),Note(3.1,40,.25),Note(3.2,-10,.5),Note(2.1,5,.75))

symphony1.tail

def duration(score: List[Note]) = {
  var result = 0.0
  for (note <- score) result += note.duration
  result
}
duration(symphony1)

def durationRec(score: List[Note]): Double = {
  if(score == Nil) 0.0
  else score.head.duration + durationRec(score.tail)
}


//def max(xs: List[Note]): Option[Note] = xs match {
//  case Nil => None
//  case List(x: Note) => Some(x)
//}


def avg(nums: List[Double]): Double = {
  if (nums.length == 0) throw new Exception("length = 0")
  var sum = 0.0
  for(i <- nums) sum += i
  sum / nums.length
}
def max(x: Double, y: Double) = if (x < y) y else x


val exam1: List[Double] = List(100, 95, 86, 42)
val exam2: List[Double] = List(35, 73.1, 80, 43.9)
val exam3: List[Double] = List(66, 80, 23.9, 55)
val exams = List(exam1, exam2, exam3)

exams.map(avg _).reduce(max _)

def maxAmp(score: List[Note]) = {
  def helper(result: Double, unseen: List[Note]): Double = {
    if (unseen == Nil) result
    else helper(math.max(result, unseen.head.amplitude),unseen.tail)
  }
  helper(0.0,score)
}
def duration2(score: List[Note]) = {
  var result = 0.0
  for(note <- score) result += note.duration
  result
}
def maxAmp3(score: List[Note]) = {

}
def maxAmp2(score: List[Note]) = {
  score.map(_.amplitude).reduce(_ max _)
}
  def maxAmpR(score: List[Note]): Double = {
    if(score == Nil) 0
    else math.max(score.head.amplitude,maxAmpR(score.tail))
  }
maxAmp2(symphony1)

def noise(note: Note) = note.frequency < 0
def filterNoise(score: List[Note]): List[Note] = {
  var newScore: List[Note] = Nil
  for(note <- score) if (!noise(note)) newScore = newScore :+ note
  newScore
}

def filterNoise2(score: List[Note]): List[Note] = {
  if(score ==Nil) Nil
  else if (noise(score.head)) filterNoise2(score.tail)
  else score.head :: filterNoise2(score.tail)
}

def filterNoise3(score: List[Note]) = {
  def helper(result: List[Note], unseen: List[Note]): List[Note] =
    if (unseen == Nil) result
    else if (noise(unseen.head)) helper(result,unseen.tail)
    else helper(unseen.head:: result, unseen.tail)
  helper(Nil, score)
}

def filterNoise4(score: List[Note]): List[Note] = {
  score.filter(!noise(_))
}
filterNoise2(symphony1)
filterNoise3(symphony1)
filterNoise4(symphony1)