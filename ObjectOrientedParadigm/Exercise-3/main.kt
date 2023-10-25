import java.time.LocalDateTime

/**
 * QUESTION: Is it better to use a Lazy Singleton or an eager Singleton?
 * 
 * It depends on the use case. For this problem I think it is better to use 
 * an Lazy Singleton, because the factories are not expensive to create, Also
 * due to the fact that they will be used from one specific place, to create
 * the agenda items. However, I'm using the factories at the beginning of the
 * program, so an Eager Singleton could be used as well. In a more detailed and 
 * complex program, I would consider when I need to use the factories and if 
 * they are expensive to create or not to decide which Singleton to use.
 */

fun main() {
    // Create factories
    val workFactory = WorkAgendaFactory.getInstance()
    val personalFactory = PersonalAgendaFactory.getInstance()

    // Create agenda
    var agenda = Agenda("Johan's Agenda")

    // Create contacts (personal and work)
    var personalContact1 = personalFactory.createContact("Me", "8888-8888")
    var personalContact2 = personalFactory.createContact("Maria", "9999-9999")
    var workContact1 = workFactory.createContact("John", "7777-7777")
    var workContact2 = workFactory.createContact("Jane", "6666-6666")

    // Create events (personal and work)
    var personalEvent1 = personalFactory.createEvent("Birthday", LocalDateTime.of(2023, 10, 22, 0, 0))
    var personalEvent2 = personalFactory.createEvent("Anniversary", LocalDateTime.of(2023, 5, 26, 0, 0))
    var workEvent1 = workFactory.createEvent("Meeting", LocalDateTime.of(2023, 10, 27, 10, 0))
    var workEvent2 = workFactory.createEvent("Conference", LocalDateTime.of(2023, 11, 15, 8, 0))

    // Add contacts and events to agenda
    agenda.addContacts(personalContact1, personalContact2, workContact1, workContact2)
    agenda.addEvents(personalEvent1, personalEvent2, workEvent1, workEvent2)

    // Print agenda
    println(agenda)
}
