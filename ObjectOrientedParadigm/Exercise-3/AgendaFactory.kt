import java.time.LocalDateTime

/**
 * AgendaFactory is an interface.
 * It is used to create Contact and Event objects.
 */
interface AgendaFactory {
    /**
     * Creates a Contact object.
     * @param name: String
     * @param phone: String
     * @return Contact
     */
    fun createContact(name: String, phone: String): Contact

    /**
     * Creates an Event object.
     * @param title: String
     * @param date: LocalDateTime
     * @return Event
     */
    fun createEvent(title: String, date: LocalDateTime): Event
}
