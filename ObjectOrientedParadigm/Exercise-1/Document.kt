class Document(name: String, vararg sheets: Sheet) {
    private var name: String = name
        get() = field
        set(value) { field = value }
    private var sheets: MutableList<Sheet> = sheets.toMutableList()
        get() = field
        set(value) { field = value }

    fun draw() {
        println("Document: $name")
        for (sheet in sheets) {
            sheet.draw()
        }
    }

    fun addSheet(sheet: Sheet) {
        sheets.add(sheet)
    }
}

