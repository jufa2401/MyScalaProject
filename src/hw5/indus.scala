package hw5

class Item(var id: Int, val description: Description) {
  override def toString: String = {
    "Item " + id.toString+ ": " + description.toString()
  }
}

object Item {
  private var currentId : Int = 0

  private def nextId: Int = {
    val temp: Int = currentId
    currentId += 1
    temp
  }

  def apply(description: Description) = new Item(nextId, description)
}

object Description {
  def apply(description: String, price: Double, supplier: String): Unit = {
    new Description(description,price.toInt,supplier)
  }
}


object Inventory {
  val dvd1 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
  val dvd2 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
  dvd1.description == dvd2.description
}

class Description(val description: String, val price: Double, val supplier: String) {
  val pr: Int = (price * 100).toInt
  override def toString: String = {
    val dollarPrice = pr.toDouble / 100
    description + "; price: $" + dollarPrice + "; supplier: " + supplier
  }

  override def equals(some: Any): Boolean = some match {
    case desc: Description => this.description == desc.description && this.price == desc.price && this.supplier == desc.supplier
    case _ => false
  }
}

object Indus extends App {
  val matrix = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
  val matrix2 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))

  println("Equality check: " + (matrix.description == matrix2.description))

  val terminator = Item(new Description("The Terminator DVD", 13.25, "DVD World"))
  val ironman = Item(new Description("Ironman DVD", 18.00, "DVD Planet"))

  var inventory = scala.collection.mutable.Map[Description, Int]()

  def addItemStock(item: Item): Unit = {
    if(!inventory.contains(item.description))
      inventory(item.description) = 1
    else
      inventory(item.description) += 1
  }

  List(matrix,matrix,terminator,terminator,terminator,ironman,ironman,ironman).foreach(addItemStock)
  inventory.foreach { case (key, value) => println(key.toString + "; Stock: " + value) }



}




