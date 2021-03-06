package org.itstep.liannoi.androidpaging.application.storage.users.sources

import io.reactivex.Maybe
import org.itstep.liannoi.androidpaging.application.common.storage.LocalDataSource
import org.itstep.liannoi.androidpaging.application.storage.core.paging.PagingDetails
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.models.UserDao

class UsersLocalDataSource constructor(
    private val userDao: UserDao
) : LocalDataSource<User, Int> {

    override fun create(entity: User) {
        userDao.create(entity)
    }

    override fun getAll(paging: PagingDetails): Maybe<List<User>> =
        userDao.getAll(paging.startPosition, paging.itemsPerPage)

    override fun getById(id: Int): Maybe<User> {
        TODO("Not yet implemented")
    }

    override fun update(entity: User) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}
