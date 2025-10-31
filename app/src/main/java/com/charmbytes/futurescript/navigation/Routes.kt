package com.charmbytes.futurescript.navigation
object Routes {
    const val Welcome = "welcome"
    const val SignIn = "signin"
    const val SignUp = "signup"
    const val AccountCreated = "account_created"
    const val Compose = "compose"
    const val Sent = "sent"
    const val Inbox = "inbox"
    const val Detail = "detail/{id}"
    fun detail(id: Long) = "detail/$id"
}
