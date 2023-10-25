import java.time.LocalDate

class Loan(partner: Partner, book: Book, date: LocalDate) {
    init {
        partner.addBooks(book)
        book.isAvailable = false
    }

    var partnerId: Long = partner.id
        private set
    var bookId: Long = book.id
        private set
    var date: LocalDate = date
        private set
    var isFinalized: Boolean = false
        private set

    override fun toString(): String {
        return "Loan(partnerId=$partnerId, bookId=$bookId, date=$date, isFinalized=$isFinalized)"
    }

    fun finalizeLoan(partner: Partner, book: Book) {
        if (partner.id != partnerId || book.id != bookId) {
            throw Exception("The partner or book doesn't match with the loan")
        }

        partner.removeBooks(book)
        book.isAvailable = true
        isFinalized = true
    }
}
