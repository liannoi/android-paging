package org.itstep.liannoi.androidpaging.application.storage.users.sources

import androidx.paging.PositionalDataSource
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.queries.ListQuery

class PagingUsersDataSource constructor(
    private val usersRepository: UsersRepository
) : PositionalDataSource<User>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<User>) {
        val startPosition: Int = params.requestedStartPosition
        val loadSize: Int = params.requestedLoadSize

        usersRepository.getAll(ListQuery(startPosition, loadSize), object : ListQuery.Handler {
            override fun onUsersFetchedSuccess(users: List<User>) {
                callback.onResult(users, 0)
            }

            override fun onUsersFetchedError(exception: String) {
                /* no-op */
            }
        })
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<User>) {
        val startPosition: Int = params.startPosition
        val loadSize: Int = params.loadSize

        usersRepository.getAll(ListQuery(startPosition, loadSize), object : ListQuery.Handler {
            override fun onUsersFetchedSuccess(users: List<User>) {
                callback.onResult(users)
            }

            override fun onUsersFetchedError(exception: String) {
                /* no-op */
            }
        })
    }
}