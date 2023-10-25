class Partner(id: Long, name: String, address: String) {
    var id: Long = id
        get() = field
        private set
    var name: String = name
        get() = field
        set(value) { field = value }
    var address: String = address
        get() = field
        set(value) { field = value }
    var books: MutableList<Book> = mutableListOf()
        private set

    override fun toString(): String {
        return "Partner(id=$id, name='$name', address='$address'"
    }

    fun addBooks(vararg books: Book) {
        for (book in books) {
            this.books.add(book)
        }
    }

    fun removeBooks(vararg books: Book) {
        for (book in books) {
            this.books.remove(book)
        }
    }
}
