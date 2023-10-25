import java.time.LocalDateTime

/**
 * PersonalAgendaFactory is a (lazy) singleton class that implements AgendaFactory.
 * It is used to create PersonalContact and PersonalEvent objects.
 * @see AgendaFactory
 */
class PersonalAgendaFactory private constructor() : AgendaFactory {
    companion object {
        @Volatile
        private var instance: PersonalAgendaFactory? = null

        /**
         * Returns the singleton instance of PersonalAgendaFactory.
         * @return instance: PersonalAgendaFactory
         */
        fun getInstance(): PersonalAgendaFactory {
            return instance ?: synchronized(this) {
                instance ?: PersonalAgendaFactory().also { instance = it }
            }
        }
    }

    /**
     * Creates a PersonalContact object.
     * @param name: String
     * @param phone: String
     * @return PersonalContact: Contact
     */
    override fun createContact(name: String, phone: String): Contact {
        return PersonalContact(name, phone)
    }

    /**
     * Creates a PersonalEvent object.
     * @param title: String
     * @param date: LocalDateTime
     * @return PersonalEvent: Event
     */
    override fun createEvent(title: String, date: LocalDateTime): Event {
        return PersonalEvent(title, date)
    }
}
