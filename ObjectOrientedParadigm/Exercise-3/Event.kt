import java.time.LocalDateTime

/**
 * Event is an abstract class.
 * It is used to create events.
 * @param title: String 
 * @param date: LocalDateTime
 */
abstract class Event(title: String, date: LocalDateTime) {
    var title: String = title
        get() = field
        private set
    var date: LocalDateTime = date
        get() = field
        private set

    /**
     * Returns a string representation of the object.
     * @return String
     */
    abstract fun printDetails(): String
}
