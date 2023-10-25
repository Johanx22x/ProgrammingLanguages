class Circle(radius: Int, center: Point) : DrawableObject {
    private var radius: Int = radius
        get() = field
        set(value) { field = value }
    private var center: Point = center
        get() = field
        set(value) { field = value }

    override fun draw(): String {
        return "Circle(radius=$radius, center=" + center.draw() + ")"
    }
}
