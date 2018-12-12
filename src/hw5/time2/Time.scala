package hw5.time2

class Time (private var h: Int, private var m: Int = 0) {
  def hours_=(newhr: Int): Unit = {
    if(newhr < 0 || newhr > 23) throw new IllegalArgumentException("Invalid hour specified")
    this.h = newhr
  }
  def hours: Int = this.h
  def minutes_=(newMin: Int): Unit = {
    if(newMin < 0 || newMin > 60) throw new IllegalArgumentException("Invalid minutes specified")
    this.m = newMin
  }
  def minutes: Int = this.m



  if (h < 0 || m < 0)
    throw new IllegalArgumentException

  val minutesSinceMidNight: Int = h * 60 + m

  def before(other: Time): Boolean = {
    if (h + m / 60.0 < other.h + other.m / 60.0){
      true
    }
    else false
  }

  override def toString: String = {
    var time = h + ":" + m
    if(m.toString.length == 1) {
      time = time+"0"
    }
    time
  }
}

object Time{
  def apply( hour: Int, minute: Int = 0) = new Time(hour, minute)
}
