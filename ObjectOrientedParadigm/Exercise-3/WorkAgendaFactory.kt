import java.time.LocalDateTime

/**
 * WorkAgendaFactory is a (lazy) singleton class that implements AgendaFactory.
 * It is used to create WorkContact and WorkEvent objects.
 * @see AgendaFactory
 */
class WorkAgendaFactory private constructor(): AgendaFactory {
    companion object {
        @Volatile
        private var instance: WorkAgendaFactory? = null

        /**
         * Returns the singleton instance of WorkAgendaFactory.
         * @return instance: WorkAgendaFactory
         */
        fun getInstance(): WorkAgendaFactory {
            return instance ?: synchronized(this) {
                instance ?: WorkAgendaFactory().also { instance = it }
            }
        }
    }

    /**
     * Creates a WorkContact object.
     * @param name: String
     * @param phone: String
     * @return WorkContact: Contact
     */
    override fun createContact(name: String, phone: String): Contact {
        return WorkContact(name, phone)
    }

    /**
     * Creates a WorkEvent object.
     * @param title: String
     * @param date: LocalDateTime
     * @return WorkEvent: Event
     */
    override fun createEvent(title: String, date: LocalDateTime): Event {
        return WorkEvent(title, date)
    }
}
