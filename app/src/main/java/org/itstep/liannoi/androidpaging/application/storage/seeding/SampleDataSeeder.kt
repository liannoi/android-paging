package org.itstep.liannoi.androidpaging.application.storage.seeding

import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.common.storage.Seeder
import org.itstep.liannoi.androidpaging.application.storage.users.commands.CreateCommand
import org.itstep.liannoi.androidpaging.application.storage.users.models.User

class SampleDataSeeder constructor(
    private val usersRepository: UsersRepository
) : Seeder {

    override fun seedAll() {
        seedUsers()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun seedUsers() {
        usersRepository.create(
            CreateCommand(User(name = "Sherri Mason", salary = 6100.0)),
            CreateCommandHandler()
        )
    }

    ///////////////////////////////////////////////////////////////////////////
    // Nested classes
    ///////////////////////////////////////////////////////////////////////////

    private class CreateCommandHandler : CreateCommand.Handler {

        override fun onUserCreatedSuccess() {
            /* no-op */
        }

        override fun onUserCreatedError(exception: String) {
            /* no-op */
        }
    }
}
