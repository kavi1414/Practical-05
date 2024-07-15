object Q3 {

  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def printFibonacciNumbers(n: Int): Unit = {
    for (i <- 0 until n) {
      println(fibonacci(i))
    }
  }

  def main(args: Array[String]): Unit = {
    printf("Enter intiger(n):")
    val n = scala.io.StdIn.readInt()
    printFibonacciNumbers(n)
  }
}
