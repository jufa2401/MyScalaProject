package hw5

trait Instruction {
  def execute(reg: Int): Int
}

class Add(val arg: Int) extends Instruction {
  def execute(reg: Int): Int = reg + arg
}

object Add {
  def apply(arg: Int) = new Add(arg)
}

class Mul(val arg: Int) extends Instruction {
  def execute(reg: Int): Int = reg * arg
}

object Mul {
  def apply(arg: Int) = new Mul(arg)
}

object Accumulator {
  var register = 0
  var program: List[Instruction] = List[Instruction]()
  def run(): Unit = program.foreach(i => register = i.execute(register))
}

object testAccum extends App {
  Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
  Accumulator.run()
  println("register = " + Accumulator.register)
  Accumulator.register = 0
  Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
  Accumulator.run()
  println("register = " + Accumulator.register)
}
