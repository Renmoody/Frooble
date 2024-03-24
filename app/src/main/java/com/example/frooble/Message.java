data class Message(var message: String) {
    constructor(contact: Contact, email : String) : this("Fruble has detected an emergency for ${contact.name}", contact.email)
}

fun setMessage (thisMess : Message, message : String) : Message{
    thisMess.message = message
    return message
}

