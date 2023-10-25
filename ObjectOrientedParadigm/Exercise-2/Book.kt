class Book(id: Long, title: String, author: String) {
    var id: Long = id
        private set
    var title: String = title
        private set
    var author: String = author
        private set
    var isAvailable: Boolean = true

    override fun toString(): String {
        return "Book(id=$id, title='$title', author='$author', isAvailable=$isAvailable)"
    }
}
