data class Contact (
    var name: String,
    var email: String,
    var phone: String,
    var contactList: MutableList<Contact> = mutableListOf(),
) {
    constructor(name: String, email: String, phone: String) : this(name, email, phone, mutableListOf())
}

fun edit(contact: Contact, NName: String, NEmail: String, NPhone: String): Contact {
    if (contact != null){
        return
    }
    if (NName != null){
        contact.name = NName

    }
    if (NEmail != null){
        contact.email = NEmail

    }
    if (NPhone != null){
        contact.phone = NPhone

    }
    contact.phone = NPhone
    return contact
}

fun addToList(contact: Contact, that: Contact) {
    contact.contactList.add(that)
}

fun deleteFromList(contact : Contact, that : Contact) {
    contact.contactList.remove(that)
}

fun getEmail (contact: Contact) : String {
    return contact.email
}

fun getName (contact: Contact) : String {
    return contact.name
}
fun getPhone (contact: Contact) : String {
    return contact.phone
}
