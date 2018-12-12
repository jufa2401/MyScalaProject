// Currying
def add(x:Int):Int=>Int =y => x+y

add(1) // Now we only get a function back
add(5)(6) // works
// I can reuse add in my plus 5 function
val plus5 = add(5)
plus5(6)

// Another way of doing the same
def add2(x: Int)(y:Int):Int= x+y
add2(5)_

val plus5_2 = add2(5)_
plus5_2(6)

// You can also unlimit arguments for last paramter



//  But why?
def courseAverage(tests:Int*)

