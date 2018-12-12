
package hw5

abstract class Expression {
  def execute: Double
}

class Number(value: Double) extends Expression {
  def execute: Double = value
  override def toString: String = value.toString
}

object Number {
  def apply(value: Double) = new Number(value)
}


class Sum(val operand1: Expression, val operand2: Expression) extends Expression {
  def execute: Double = operand1.execute + operand2.execute
  override def toString: String = "(+ " + operand1 + " " + operand2 + ")"
}

object Sum {
  def apply(operand1: Expression, operand2: Expression) =
    new Sum(operand1, operand2)
}

class Product(val operand1: Expression, val operand2: Expression) extends Expression {
  def execute: Double = operand1.execute * operand2.execute
  override def toString: String = "(* " + operand1 + " " + operand2 + ")"
}

object Product {
  def apply(operand1: Expression, operand2: Expression) =
    new Product(operand1, operand2)
}

object TestAcorn extends App {
  var exp: Expression = Product(Number(4), Sum(Number(2), Number(2)))
  println("the value of " + exp + " = " + exp.execute)
  exp = Product(Number(2), Product(Number(3), Number(5)))
  println("the value of " + exp + " = " + exp.execute)
}

