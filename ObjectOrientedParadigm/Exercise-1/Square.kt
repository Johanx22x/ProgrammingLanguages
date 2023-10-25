class Square(side: Int, center: Point) : DrawableObject {
    private var side: Int = side
        get() = field
        set(value) { field = value }
    private var center: Point = center
        get() = field
        set(value) { field = value }

    override fun draw(): String {
        return "Square(side=$side, center=" + center.draw() + ")"
    }
}
