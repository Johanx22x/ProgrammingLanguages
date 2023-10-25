class Sheet(name: String, vararg objects: DrawableObject) {
    private var name: String = name
        get() = field
        set(value) { field = value }
    private var objects: Array<out DrawableObject> = objects
        get() = field
        set(value) { field = value }

    fun draw() {
        println("Sheet: $name")
        for (obj in objects) {
            println("\t" + obj.draw())
        }
    }
}

