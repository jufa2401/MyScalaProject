package midterm_training.oop

/**
  * class Counter {
  * private int modulus = 8
  * private int count = 0
  * public int getCount()
  * public void setCount(int c)
  * public int get Modulus()
  *
  */

// Below is same as above, as it can be seen the constructor creates getters and setters automatically (only getter if private)
class Counter(val modulus: Int = 8, private var count: Int = 0) {
  def inc() { count = (count + 1) % modulus }
  def getCount: Int = count
}
// Companion object - Special instance of counter that has more "features", one-of-a-kind methods.
object Counter {
  def apply(modulus: Int = 8, count: Int = 0) =
    new Counter(modulus, count)
  def test() {
    val c1 = new Counter(4)
    val c2 = Counter(16, 1) // notice no new, so it is referring to companion
    for(i <- 0 to 10) {
      c1.inc()
      c2.inc()
    }
    print("count = " + c1.getCount)
    println(" % " +c1.modulus)
    print("count = " + c2.getCount)
    println(" % " +c2.modulus)
  }
}