package org.itstep.liannoi.androidpaging.application.storage.users.models

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import org.itstep.liannoi.androidpaging.application.ApplicationDefaults
import org.itstep.liannoi.androidpaging.application.common.storage.BaseDao

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT U.UserId, U.Name, U.Salary FROM Users AS U ORDER BY U.UserId ASC LIMIT :itemsPerPage OFFSET :startPosition")
    fun getAll(
        startPosition: Int = ApplicationDefaults.PAGING_START_POSITION,
        itemsPerPage: Int = ApplicationDefaults.PAGING_ITEMS_PER_PAGE
    ): Maybe<List<User>>
}
