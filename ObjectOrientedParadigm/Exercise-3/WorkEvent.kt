import java.time.LocalDateTime

/**
 * WorkEvent is a subclass of Event.
 * It is used to create work events.
 * @see Event
 */
class WorkEvent(title: String, date: LocalDateTime): Event(title, date) {
    /**
     * Returns a string representation of the object.
     * @return String
     */
    override fun printDetails(): String {
        return "WorkEvent(title=$title, date=$date)"
    }
}
