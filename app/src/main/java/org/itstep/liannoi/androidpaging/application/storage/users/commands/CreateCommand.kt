package org.itstep.liannoi.androidpaging.application.storage.users.commands

import org.itstep.liannoi.androidpaging.application.storage.users.models.User

class CreateCommand(val user: User) {

    interface Handler {

        fun onUserCreatedSuccess()

        fun onUserCreatedError(exception: String)
    }
}
