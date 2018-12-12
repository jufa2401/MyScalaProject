trait Value

trait Expression {
  def execute: Value
}
trait Literal extends Value with Expression {
  def execute = this
}

class Number (val value: Double) extends Literal {
  override def toString = value.toString
}
object Number {
  def apply(value: Double) = new Number(value)
}

class Boole (val value: Boolean) extends Literal {
  override def toString = value.toString
}
object Boole {
  def apply(value: Boolean) = new Boole(value)
}
class Sum(val operand1: Expression, val operand2: Expression) extends Expression {
  def execute =  {
    val arg1 = operand1.execute
    val arg2 = operand2.execute
    if (!arg1.isInstanceOf[Number] || !arg2.isInstanceOf[Number]) {
      throw new Exception("sum inputs must be numbers")
    }
    val num1 = arg1.asInstanceOf[Number]
    val num2 = arg2.asInstanceOf[Number]
    new Number(num1.value + num2.value)
  }
}

// and a companion object
object Sum {
  def apply(operand1: Expression, operand2: Expression) = new Sum(operand1, operand2)
}