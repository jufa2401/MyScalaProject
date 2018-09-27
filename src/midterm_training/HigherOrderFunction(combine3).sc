def combine3(x:Double, y: Double, z:Double, f:(Double,Double) => Double):Double ={
  f(f(x,y),z)   //  (x+y)+z (where plus is whatever operation specified by argument func
}
// Below i am using lambda underscore notation to define a function
combine3(1,2,3,_+_)
// See now I am using the same function just by specifiying a function it can use
combine3(1,2,3,_*_)
// Finding minimum
combine3(2,5,1,_ min _)

combine3(7,6,2,(x,y)=> x*y)
