package hw5

import scala.collection.mutable.ArrayBuffer

class GenericQueue[T](private var arrBuf: ArrayBuffer[T] = ArrayBuffer[T]()) {

  def enQueue[V](item: T) = {
    arrBuf += item
  }
  def deQueue[V](): T = {
    val item = arrBuf.head
    arrBuf = arrBuf.tail
    item
  }
  def isEmpty: Boolean = arrBuf.isEmpty
  override def toString: String = {
    arrBuf.toString
  }
}
object GenericQueue {
  def apply[T]: GenericQueue[T] = {
    new GenericQueue[T]()
  }

  def main(args: Array[String]): Unit = {
    val waitingList = GenericQueue[String]
    waitingList.enQueue("Bob")
    waitingList.enQueue("Jens")
    waitingList.enQueue("Ole")
    waitingList.enQueue("Kaj")
    waitingList.enQueue("Fahad")
    println(waitingList)

    while (!waitingList.isEmpty) {
      waitingList.deQueue
      println(waitingList)
    }
  }
}



