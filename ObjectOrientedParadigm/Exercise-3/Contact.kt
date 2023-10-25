/**
 * Abstract class Contact
 * It is used to create contacts.
 * @param name: String
 * @param phone: String
 */
abstract class Contact(name: String, phone: String) {
    var name: String = name
        get() = field
        private set
    var phone: String = phone
        get() = field
        private set

    /**
     * Returns a string representation of the object.
     * @return String
     */
    abstract fun printDetails(): String
}
