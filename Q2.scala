case class Book(title: String, author: String, isbn: String)

object Q2 {
  private var library: Set[Book] = Set(
    Book("Madoldoowa", "Martin Wick", "1234567890"),
    Book("HathPana", "Kumarathunga Munidasa", "0987654321"),
    Book("Nil Katarolu", "Mohan Raj", "1122334455")
  )

  private def addBook(book: Book): Unit = {
    if (isBookInLibrary(book.isbn)) {
      println(s"Book with ISBN ${book.isbn} already exists in the library.")
    } else {
      library += book
      println(s"Book added: ${book.title}")
    }
  }

  private def removeBookByISBN(isbn: String): Unit = {
    if (isBookInLibrary(isbn)) {
      library = library.filterNot(_.isbn == isbn)
      println(s"Book with ISBN $isbn removed.")
    } else {
      println(s"No book found with ISBN $isbn.")
    }
  }

  private def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  private def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach { book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    }
  }

  private def searchBookByTitle(title: String): Unit = {
    val booksFound = library.filter(_.title.toLowerCase == title.toLowerCase)
    if (booksFound.nonEmpty) {
      println(s"Book(s) found with title '$title':")
      booksFound.foreach { book =>
        println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      }
    } else {
      println(s"No book found with title '$title'.")
    }
  }

  private def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.toLowerCase == author.toLowerCase)
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    } else {
      println(s"No books found by author '$author'.")
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    addBook(Book("MagulKaama", "Kumarathunga Munidasa", "2233445566"))

    removeBookByISBN("0987654321")

    println(s"Is book with ISBN 1122334455 in library? ${isBookInLibrary("1122334455")}")

    searchBookByTitle("Madoldoowa")

    displayBooksByAuthor("Kumarathunga Munidasa")

    displayLibrary()
  }
}
