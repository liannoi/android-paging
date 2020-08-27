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
        val users: List<User> = listOf(
            User(name = "Sherri Mason", salary = 6100.0),
            User(name = "Gary Carroll", salary = 2900.0),
            User(name = "Margaret Horne", salary = 3100.0),
            User(name = "Michael Rodriquez", salary = 4600.0),
            User(name = "Patricia Bookout", salary = 4000.0)
        )

        val handler = CreateCommandHandler()
        users.stream().forEach { usersRepository.create(CreateCommand(it), handler) }
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
