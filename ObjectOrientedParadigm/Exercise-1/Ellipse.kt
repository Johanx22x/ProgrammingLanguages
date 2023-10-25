class Ellipse(a: Int, b: Int, center: Point) : DrawableObject {
    private var a: Int = a
        get() = field
        set(value) { field = value }
    private var b: Int = b
        get() = field
        set(value) { field = value }
    private var center: Point = center
        get() = field
        set(value) { field = value }

    override fun draw(): String {
        return "Ellipse(a=$a, b=$b, center=" + center.draw() + ")"
    }
}
