import java.time.LocalDateTime

/**
 * PersonalEvent is a subclass of Event.
 * It is used to create personal events.
 * @see Event
 */
class PersonalEvent(title: String, date: LocalDateTime): Event(title, date) {
    /**
     * Returns a string representation of the object.
     * @return String
     */
    override fun printDetails(): String {
        return "PersonalEvent(title=$title, date=$date)"
    }
}
