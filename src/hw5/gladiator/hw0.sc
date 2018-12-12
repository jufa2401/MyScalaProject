
class Gladiator (val name: String) {
  private var health: Int = 100

  def damage(amount: Int): Unit = {
    this.health = this.health - amount
    if(this.health < 0) this.health = 0
    println("Health is now " + RED_BOLD + health + RESET)
  }
  def attack(opponent: Gladiator): Unit = {
    println(GREEN_BOLD + name + RESET + " is attacking: " + RED_BOLD + opponent.name + RESET)
    opponent.damage(5)
  }
  /*
    This will color the console output, it is easier to interpret what is actually going,
    while still printing the slash slash, crush, crush etc. on with this
   */
  val RED_BOLD = "\033[1;31m"
  val GREEN_BOLD = "\033[1;32m"
  val YELLOW_BOLD = "\033[1;33m"
  val RESET = "\033[0m"
}

object Gladiator{
  def apply(name: String) = new Gladiator(name)
}
trait Masher {
  def mash(opponent: Gladiator): Unit ={
    println("Mash, mash, mashing " + opponent.name)
    opponent.damage(10)
  }
}
trait Slasher {
  def slash(opponent: Gladiator): Unit = {
    println(" slash slash slashing" + opponent.name)
    opponent.damage(10)
  }
}
trait Crusher {
  def crush(opponent: Gladiator): Unit ={
    println("Crush crush crushing: " + opponent.name)
    opponent.damage(10)
  }
}
class CrusherMasher(override val name : String) extends Gladiator(name) with Crusher with Masher {
  override def attack(opponent: Gladiator): Unit = {
    super.attack(opponent)
    super.crush(opponent)
    super.mash(opponent)
  }

}

object TestGladiator extends App {
  for(_ <- 0 to 5) {
    maximus.attack(bee)
    bee.attack(maximus)
  }

  object bee extends Gladiator("Bumblebee") with Crusher with Masher {
      override def attack(opponent: Gladiator): Unit = {
          super.attack(opponent)
          super.crush(opponent)
          super.mash(opponent)
    }
  }

  object maximus extends CrusherMasher("Maximus Prime") {}

}

