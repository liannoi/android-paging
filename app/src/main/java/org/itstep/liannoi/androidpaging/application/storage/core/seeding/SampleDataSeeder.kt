package org.itstep.liannoi.androidpaging.application.storage.core.seeding

import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.common.storage.Seeder
import org.itstep.liannoi.androidpaging.application.storage.core.paging.PagingDetails
import org.itstep.liannoi.androidpaging.application.storage.users.commands.CreateCommand
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.queries.ListQuery
import java.util.*
import kotlin.random.Random.Default.nextInt

class SampleDataSeeder constructor(
    private val usersRepository: UsersRepository
) : Seeder {

    override fun seedAll() {
        usersRepository.getAll(ListQuery(PagingDetails()), ListQueryHandler())
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun seedUsers() {
        val users: MutableList<User> = mutableListOf(
            User(name = "Sherri Mason", salary = 6100),
            User(name = "Gary Carroll", salary = 2900),
            User(name = "Margaret Horne", salary = 3100),
            User(name = "Michael Rodriquez", salary = 4600),
            User(name = "Patricia Bookout", salary = 4000)
        )

        (0..100).forEach { _ ->
            users.add(
                User(
                    name = UUID.randomUUID().toString().take(20),
                    salary = nextInt(300, 10000)
                )
            )
        }

        val handler = CreateCommandHandler()
        users.stream().forEach { usersRepository.create(CreateCommand(it), handler) }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Nested classes
    ///////////////////////////////////////////////////////////////////////////

    private inner class ListQueryHandler : ListQuery.Handler {

        override fun onUsersFetchedSuccess(users: List<User>) {
            if (users.isNotEmpty()) return

            seedUsers()
        }

        override fun onUsersFetchedError(exception: String) {
            /* no-op */
        }
    }

    private class CreateCommandHandler : CreateCommand.Handler {

        override fun onUserCreatedSuccess() {
            /* no-op */
        }

        override fun onUserCreatedError(exception: String) {
            /* no-op */
        }
    }
}
