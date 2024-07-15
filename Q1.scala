object Q1 {
  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    println("\nProduct List:")
    printProductList(productList)
    println("\nTotal Products: " + getTotalProducts(productList))
  }

  def getProductList(): List[String] = {
    var productList: List[String] = Nil // Initialize an empty list
    var productName: String = ""

    
    while (true) {
      println("Enter product name (or 'done' to finish):")
      productName = scala.io.StdIn.readLine() // Read input from user
      if (productName == "done") {
        // Break the loop if user types "done"
        return productList
      }
      productList = productList :+ productName // Append the product name to the list
    }
    
    productList // Return the final list of product names (not reached)
  }

  def printProductList(productList: List[String]): Unit = {
    productList.zipWithIndex.foreach { case (name, index) =>
      println((index + 1) + ". " + name) // Print each product with its position (1-based index)
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    productList.length // Return the length of the product list
  }
}
