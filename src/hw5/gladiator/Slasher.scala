package hw5.gladiator

trait Slasher {
  def slash(opponent: Gladiator): Unit = {
    println(" slash slash slashing" + opponent.name)
    opponent.damage(10)
  }
}