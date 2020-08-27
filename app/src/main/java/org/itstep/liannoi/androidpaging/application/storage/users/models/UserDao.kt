package org.itstep.liannoi.androidpaging.application.storage.users.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Maybe

@Dao
interface UserDao {

    @Query("SELECT * FROM Users")
    fun getAll(): Maybe<List<User>>

    @Insert
    fun create(user: User)
}
