package org.itstep.liannoi.androidpaging.infrastructure.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.models.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
