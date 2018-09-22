// Problem 1
isPal("rotator ")
isPal("cat")
isPal("Civic")
isPal("Toyota")
isPal("$3.1441.3$")
def isPal(string: String): Boolean = {
  val regex = "[^A-Za-z0-9]"
  val newstring = string.replaceAll(regex,"")
  if(newstring.matches(newstring.reverse)) true
  else false
}

//Problem 2
isPal2("A man, a plan, a canal, Panama!")
def isPal2(string: String): Boolean = {
  val newstring = string.toLowerCase.replaceAll("[^A-Za-z0-9]","")
  if(newstring.matches(newstring.reverse)) true
  else false
}

//Problem 3
mkPal("mars")
def mkPal(string: String):String = {
  string + string.reverse
}

//Problem 4
mkWord()
mkWord(20)
def mkWord(size: Int = 5): String = {
  val chars = 'a' to 'z'
  val sb = new StringBuilder
  for (i <- 1 to size) {
    val randomNum = util.Random.nextInt(chars.length)
    sb.append(chars(randomNum))
  }
  sb.toString
}
// Problem 5
mkSentence(20)
def mkSentence(size: Int = 40): String = {
  val capchars = 'A' to 'Z'
  val sb = new StringBuilder
  sb.append(capchars(util.Random.nextInt(26)))
  val n = util.Random.nextInt(10)
  for(i <- 0 to n){
    sb.append(mkWord())
    if(i<n) sb.append(" ")
  }
  sb.append(".")
  sb.toString
}
// Problem 6
shuffle("abcdefghij")
def shuffle(string: String): String = {
  val start = string.take(string.length/2)
  val end = string.drop(string.length/2)
//  Another way to do it:
//  val start = string.substring(0,string.length/2)
//  val end = string.substring(string.length/2)

  end+start
}
// Problem 7
countSubstrings("is", "Mississippi")
def countSubstrings(substring:String, str:String) = substring.r.findAllMatchIn(str).length


eval("3.14+42")
eval("  -26 +  -49.99  ")
eval("21 * 43")
try{
eval("abc + 3")
} catch {
  case e: Exception => println(e)
}
// Problem 8 and 9
def eval(expression: String): Double = {
  if(expression.contains("/")) throw new Exception("Missing operator, cannot divide")
  if(expression.contains("%")) throw new Exception("Missing operator, cannot do modulus")
  val strarr = expression.trim().split("[+*]")
  if(expression.contains("*")) strarr(0).trim.toDouble*strarr(1).trim.toDouble
  else strarr(0).trim.toDouble+strarr(1).trim.toDouble
}





