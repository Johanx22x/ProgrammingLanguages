class Line(start: Point, end: Point) : DrawableObject {
    private var start: Point = start
        get() = field
        set(value) { field = value }
    private var end: Point = end
        get() = field
        set(value) { field = value }

    override fun draw(): String {
        return "Line(start=" + start.draw() + ", end=" + end.draw() + ")"
    }
}
