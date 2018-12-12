
class Entry (val temp: Double, val mon: Int, val day: Int)  {
  override def toString: String = "[temp: " +temp + ", mon: "+mon + " day: "+day+"]"
}

def monthcheck (entry: Entry, month: Int): Boolean = {
  if(entry.mon == month) true else false
}

def fahrenheit(entry: Entry): Double = {
  (entry.temp*9/5)+32
}

def avgTemp(month: Int, log: List[Entry]): Double = {
  val l1 = log.filter(monthcheck(_,month))
  val tempCnt = l1.length
  val l2 = l1.map(fahrenheit).sum
  l2/tempCnt
}

val log = List(new Entry(20, 1, 1), new Entry(25, 1, 2), new Entry(15, 2, 2), new
    Entry(10, 1, 3), new Entry(22, 6, 5))

avgTemp(1,log)



class Knight(val name: String)    {
  var health = 100
  var strategy: AttackStrategy = null
  def attack(opponent: Knight) {
    println(name + " is attacking " + opponent.name)
    strategy.attack(opponent)
    println(opponent.name + ".health = " + opponent.health)
  }
}
trait AttackStrategy {
  def attack(opponent: Knight):Unit = {}
}
object Mace extends AttackStrategy {
  override def attack(opponent: Knight): Unit = {
    super.attack(opponent)
    println("macing")
    opponent.health = opponent.health-10
  }
}
object Stab extends AttackStrategy {
  override def attack(opponent: Knight): Unit = {
    super.attack(opponent)
    println("stabbing")
    opponent.health = opponent.health-15
  }
}
class CompositeStrategy (val weapons: List[AttackStrategy]) extends AttackStrategy {
  override def attack(opponent: Knight): Unit = {
    super.attack(opponent)
    weapons.foreach(
      f => f.attack(opponent)
    )
  }
}


val k1 = new Knight("Drobot")
val k2 = new Knight("Baldimore")
k1.strategy = Mace
k2.strategy = new CompositeStrategy(List(Mace,Stab,Stab))
k1.attack(k2)
k2.attack(k1)