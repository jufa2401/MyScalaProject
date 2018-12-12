package hw5.time1

class Time (val hours: Int, val minutes: Int = 0) {

  if (hours < 0 || minutes < 0)
    throw new IllegalArgumentException

  val minutesSinceMidNight: Int = hours * 60 + minutes

  def before(other: Time): Boolean = {
    if (hours + minutes / 60.0 < other.hours + other.minutes/ 60.0){
      true
    }
    else false
  }

  override def toString: String = {
    var time = hours + ":" + minutes
    if(minutes.toString.length == 1) {
      time = time+"0"
    }
    time
  }
}

object Time{
  def apply( hour: Int, minute: Int = 0) = new Time(hour, minute)
}