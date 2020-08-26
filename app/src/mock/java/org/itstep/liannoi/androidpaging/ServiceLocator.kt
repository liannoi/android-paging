package org.itstep.liannoi.androidpaging

import android.content.Context
import androidx.room.Room
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.common.storage.LocalDataSource
import org.itstep.liannoi.androidpaging.application.storage.users.DefaultUsersRepository
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.sources.UsersLocalDataSource
import org.itstep.liannoi.androidpaging.infrastructure.persistence.ApplicationDatabase

object ServiceLocator {

    private var database: ApplicationDatabase? = null

    @Volatile
    var usersRepository: UsersRepository? = null

    fun provideUsersRepository(context: Context): UsersRepository {
        synchronized(this) {
            return usersRepository ?: usersRepository ?: createUsersRepository(context)
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun createUsersRepository(context: Context): UsersRepository {
        val newRepo = DefaultUsersRepository(createUsersLocalDataSource(context))
        usersRepository = newRepo

        return newRepo
    }

    private fun createUsersLocalDataSource(context: Context): LocalDataSource<User, Int> {
        val database: ApplicationDatabase = database ?: createDatabase(context)

        return UsersLocalDataSource(database.userDao())
    }

    private fun createDatabase(context: Context): ApplicationDatabase {
        val result: ApplicationDatabase = Room.databaseBuilder(
            context.applicationContext,
            ApplicationDatabase::class.java,
            "Users.db"
        ).build()

        database = result

        return result
    }
}
