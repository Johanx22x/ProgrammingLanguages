/**
 * PersonalContact is a subclass of Contact.
 * It is used to create personal contacts.
 * @see Contact
 */
class PersonalContact(name: String, phone: String) : Contact(name, phone) {
    /**
     * Returns a string representation of the object.
     * @return String
     */
    override fun printDetails(): String {
        return "PersonalContact(name='$name', phone='$phone')"
    }
}
