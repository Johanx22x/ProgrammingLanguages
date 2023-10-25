class Rectangle(width: Int, height: Int, center: Point) : DrawableObject {
    private var width: Int = width
        get() = field
        set(value) { field = value }
    private var height: Int = height
        get() = field
        set(value) { field = value }
    private var center: Point = center
        get() = field
        set(value) { field = value }

    override fun draw(): String {
        return "Rectangle(width=$width, height=$height, center=" + center.draw() + ")"
    }
}
