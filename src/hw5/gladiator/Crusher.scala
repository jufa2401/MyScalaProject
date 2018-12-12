package hw5.gladiator

trait Crusher {
  def crush(opponent: Gladiator): Unit ={
    println("Crush crush crushing: " + opponent.name)
    opponent.damage(10)
  }
}
