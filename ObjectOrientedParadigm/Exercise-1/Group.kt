class Group(vararg objects: DrawableObject) : DrawableObject {
    private var objects: Array<out DrawableObject> = objects
        get() = field
        set(value) { field = value }

    override fun draw(): String {
        var result = "Group("
        for (obj in objects) {
            result += obj.draw() + ", "
        }
        result = result.substring(0, result.length - 2)
        result += ")"
        return result
    }
}
