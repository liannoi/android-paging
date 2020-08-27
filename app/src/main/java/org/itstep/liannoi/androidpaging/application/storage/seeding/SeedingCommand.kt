package org.itstep.liannoi.androidpaging.application.storage.seeding

import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository

class SeedingCommand {

    class Handler constructor(
        private val usersRepository: UsersRepository
    ) {

        fun handle() {
            SampleDataSeeder(usersRepository).seedAll()
        }
    }
}
