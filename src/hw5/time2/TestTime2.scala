package hw5.time2
object TestTime2 extends App {
  try {
    val t1 = Time(3, 45)
    val t2 = Time(3)
    println("t1 = " + t1)
    println("t2 = " + t2)
    println("t1 < t2 = " + t1.before(t2))
    t1.hours = 20
    t1.minutes = 60

    println("t1 minutes since midnight = " + t1.minutesSinceMidNight)
    val t3 = Time(14, 60) // oops!
  } catch {
    case e: IllegalArgumentException => println(e)
  }

}

//case class Time(val t1 : Int, val t2: Int = 0) {
//
////  if(t1 < 0 || )
//  val minutesSinceMidNight = ()
//  def before (some: Time): Boolean = {
//    val someTimeinMinutes = some.minute + 60 + some.minute
//    val someTimeinMinutes2 = some.hour + 60 + some.hour
//    someTimeinMinutes < someTimeinMinutes2
//  }
////  override to
//
//}
//
//t1 = 3:45
//t2 = 3:00
//t1 < t2 = false
//t1 minutes since midnight = 225