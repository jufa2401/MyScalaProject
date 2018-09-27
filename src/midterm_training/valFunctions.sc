val foo = 1 to 5 toList
val add1 = (x:Int) => x+1
val add100 = (x:Int) => x+100
val sq = (x:Int) => x*x

val min3 = (x:Double, y: Double, z:Double) => x min y min z
min3(5,232,4)



// Map performs value operations on another value
foo map add1
foo map add100
foo map sq

val bar = foo map add1
bar map sq
val nointermedRes = foo map add1 map sq
/*
What we just did, above, was sq(add1(x)) for every x in the list foo.
We could have instead composed the two functions,
since sq(add1(x)) = sqοadd1(x). Here’s what it looks like in Scala:
 */


val sqComposeAdd1 = sq compose add1
foo map sqComposeAdd1
//Of course, we can do this with more than two functions.

foo map add1 map sq map add100

foo map (add100 compose sq compose add1)
/*
And so on. Now, imagine that you want the user of a program you’ve written to be able to select the functions they want to apply to a list of items,
perhaps from a set of predefined functions you’ve provided plus perhaps ones they are themselves defining.
So, here’s the really useful part: we can compose that arbitrary bunch of functions on the fly to turn them into a single function,
without having to write out “compose … compose … compose…” or “map … map … map …”
We do this by building up a list of the functions (in the order we want to apply them to the values) and then reducing them using the compose function.
Equivalent to what we had above:
 */
// (1+1)^2+100 and so on..
val fncs = List(add1,sq,add100)

foo map (fncs.reverse reduce (_ compose _))
/*
Notice the that it was necessary to reverse the list in order for the composition to be
ordered correctly. If you don’t feel like doing that,
you can use andThen in Scala.
 */
foo map (add1 andThen sq andThen add100)
foo map ( fncs reduce (_ andThen _) )

val superFunction = fncs reduce (_ andThen _)
foo map superFunction