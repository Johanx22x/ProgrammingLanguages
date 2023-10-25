/**
 * Agenda class
 * @param name Agenda name
 * @property contacts List of contacts
 * @property events List of events
 * @constructor Creates an agenda with a name
 */
class Agenda(name: String) {
    var name: String = name
        get() = field
        private set
    private var contacts: MutableList<Contact> = mutableListOf()
    private var events: MutableList<Event> = mutableListOf()

    /**
     * addContacts adds contacts to the agenda 
     * @param contacts: Contact 
     */
    fun addContacts(vararg contacts: Contact) {
        for (contact in contacts) {
            this.contacts.add(contact)
        }
    }

    /**
     * removeContacts removes contacts from the agenda 
     * @param contacts: Contact 
     */
    fun removeContacts(vararg contacts: Contact) {
        for (contact in contacts) {
            this.contacts.remove(contact)
        }
    }

    /**
     * addEvents adds events to the agenda 
     * @param events: Event 
     */
    fun addEvents(vararg events: Event) {
        for (event in events) {
            this.events.add(event)
        }
    }

    /**
     * removeEvents removes events from the agenda 
     * @param events: Event 
     */
    fun removeEvents(vararg events: Event) {
        for (event in events) {
            this.events.remove(event)
        }
    }

    /**
     * Returns a string representation of the object.
     * @return String
     */
    override fun toString(): String {
        var result = "Agenda(\n\tname=$name,\n\tcontacts=["
        for (contact in contacts) {
            result += "\n\t\t" + contact.printDetails() + ", "
        }
        result = result.substring(0, result.length - 2)
        result += "\n\t], \n\tevents=["
        for (event in events) {
            result += "\n\t\t" + event.printDetails() + ", "
        }
        result = result.substring(0, result.length - 2)
        result += "\n\t]\n)"
        return result
    }
}
