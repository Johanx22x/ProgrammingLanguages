/**
 * WorkContact is a subclass of Contact.
 * It is used to create work contacts.
 * @see Contact
 */
class WorkContact(name: String, phone: String): Contact(name, phone) {
    /**
     * Returns a string representation of the object.
     * @return String
     */
    override fun printDetails(): String {
        return "WorkContact(name='$name', phone='$phone')"
    }
}
