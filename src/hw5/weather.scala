package hw5

trait IThermometer {
  // = avg degrees Farenheit
  def getMeanTemperature(cities: List[String]): Double
}

class CelsiusTherm {
  // = degrees Celsius
  def computeTemp(city: String): Double = 50 * math.random // fake temperature for now
}

class ThermAdapter extends CelsiusTherm with IThermometer {
  def celsius2fahrenheit(celsius: Double): Double = 1.8 * celsius + 32
  def getMeanTemperature(cities: List[String]): Double = {
    cities.map(computeTemp).map(celsius2fahrenheit).sum/cities.size
  }
}

object WeatherStation extends App {
  val thermometer: IThermometer = new ThermAdapter
  val avgTemp = thermometer.getMeanTemperature(List("CPH", "STOCK", "OSLO"))
  println("avg temp = " + avgTemp)
}

