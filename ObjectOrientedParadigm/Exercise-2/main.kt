import java.time.LocalDate

fun main() {
    // Create library
    var library: Library = Library("Biblioteca TEC Sede San Carlos")

    // Create books
    var book1: Book = Book(1, "The Lord of the Rings: The Fellowship of the Ring", "J. R. R. Tolkien")
    var book2: Book = Book(2, "One Piece", "Eiichiro Oda")
    var book3: Book = Book(3, "Comprendiendo las Probabilidades", "Henrik Niederhausen")
    var book4: Book = Book(4, "Lenguajes de Programación", "Oscar Viquez")
    var book5: Book = Book(5, "The Lord of the Rings: The Two Towers", "J. R. R. Tolkien")
    var book6: Book = Book(6, "Chainsaw Man", "Tatsuki Fujimoto")
    var book7: Book = Book(7, "Calculus", "James Stewart")
    var book8: Book = Book(8, "The Lord of the Rings: The Return of the King", "J. R. R. Tolkien")

    // Create partners
    var partner1: Partner = Partner(1, "Johan Rodriguez", "Sta Rosa de Pocosol")
    var partner2: Partner = Partner(2, "Unknow Name", "Unknow Address")

    // Create loans
    var loan1: Loan = Loan(partner1, book7, LocalDate.of(2023, 10, 22))
    var loan2: Loan = Loan(partner1, book2, LocalDate.of(2023, 10, 22))
    var loan3: Loan = Loan(partner1, book3, LocalDate.of(2023, 10, 22))
    var loan4: Loan = Loan(partner1, book6, LocalDate.of(2023, 10, 24))
    var loan5: Loan = Loan(partner2, book1, LocalDate.of(2023, 9, 30))
    var loan6: Loan = Loan(partner2, book5, LocalDate.of(2023, 10, 1))

    // Add books to Library
    library.addBooks(book1, book2, book3, book4, book5, book6, book7, book8)

    // Add partners to Library 
    library.addPartners(partner1, partner2)

    // Add loans to Library
    library.addLoans(loan1, loan2, loan3, loan4, loan5, loan6)

    // Print Library
    println(library)
    println()

    // Print relevant information
    println("Books available: ${library.getAvailableBooks()}")
    println()
    println("Partners with more than 3 books: ${library.getPartnersWithMoreThanNBooks(3)}")
    println()

    // Finalize some loans, simulating that the partners returned the books
    loan1.finalizeLoan(partner1, book7)
    loan2.finalizeLoan(partner1, book2)
    loan3.finalizeLoan(partner1, book3)
    println("Loans finalized!")
    println()

    // Print relevant information, actualized
    println("Books available: ${library.getAvailableBooks()}")
    println()
    println("Partners with more than 3 books: ${library.getPartnersWithMoreThanNBooks(3)}")
}
