package hw5.gladiator

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

