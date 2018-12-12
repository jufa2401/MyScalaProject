package hw5.gladiator

class CrusherMasher(override val name : String) extends Gladiator(name) with Crusher with Masher {
    override def attack(opponent: Gladiator): Unit = {
        super.attack(opponent)
        super.crush(opponent)
        super.mash(opponent)
    }

}


