import java.time.LocalDate

class Library(name: String) {
    var name: String = name
    private var books: MutableList<Book> = mutableListOf()
    private var partners: MutableList<Partner> = mutableListOf()
    private var loans: MutableList<Loan> = mutableListOf()

    override fun toString(): String {
        var result: String = "Library(\n\tname='$name', \n\tbooks=("
        for (book in books) {
            result += "\n\t\t$book, "
        }
        result = result.substring(0, result.length - 2)
        result += "), \n\tpartners=("
        for (partner in partners) {
            result += "\n\t\t$partner, "
        }
        result = result.substring(0, result.length - 2)
        result += "), \n\tloans=("
        for (loan in loans) {
            result += "\n\t\t$loan, "
        }
        result = result.substring(0, result.length - 2)
        result += "))"
        return result
    }

    fun addBooks(vararg books: Book) {
        for (book in books) {
            this.books.add(book)
        }
    }

    fun addPartners(vararg partners: Partner) {
        for (partner in partners) {
            this.partners.add(partner)
        }
    }

    fun addLoans(vararg loans: Loan) {
        for (loan in loans) {
            this.loans.add(loan)
        }
    }

    fun getPartnersWithMoreThanNBooks(n: Int): List<Partner> {
        return partners.filter { it.books.size > n }
    }

    fun getAvailableBooks(): List<Book> {
        return books.filter { it.isAvailable }
    }
}
