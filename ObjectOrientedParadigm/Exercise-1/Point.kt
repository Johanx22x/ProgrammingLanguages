class Point(x: Int, y: Int) : DrawableObject {
    private var x: Int = x
        get() = field
        set(value) { field = value }
    private var y: Int = y
        get() = field
        set(value) { field = value }

    override fun draw(): String {
        return "Point(x=$x, y=$y)"
    }
}
