package org.itstep.liannoi.androidpaging.application.storage.users.models

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import org.itstep.liannoi.androidpaging.application.common.storage.BaseDao

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM Users")
    fun getAll(): Maybe<List<User>>
}
