def controlLoop[S](state: S, cycle: Int, halt: (S,Int)=> Boolean, update: (S, Int) => S): (S, Int) = {
//  Checks if halted, then returns state. By specifying Int as return, i can also see at what cycle it ends
  if(halt(state,cycle)) (state,cycle)
//   Otherwise it updates state, then we update cycle by incrementing with 1. Then we update and go back into the controlloop with new values
  else controlLoop(update(state,cycle),cycle+1,halt,update)

}
// Since the control loop automatically updates cycle, all we have to do is specify the boolean statement, and growth between cycle
controlLoop[Int](1,0,
  (pop: Int, cycle: Int) => pop >= 100000,
  (pop: Int, cycle: Int) => pop*2)




def test(init: Int):Int = {
  var i = init
  for(n<-1 to 17) {
    i = i * 2
  }
  i
}
test(1)