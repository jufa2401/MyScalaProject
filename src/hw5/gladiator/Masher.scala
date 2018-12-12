package hw5.gladiator

trait Masher {
  def mash(opponent: Gladiator): Unit ={
    println("Mash, mash, mashing " + opponent.name)
    opponent.damage(10)
  }
}