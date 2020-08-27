package org.itstep.liannoi.androidpaging.presentation.users.paging

import android.util.Log
import androidx.paging.PositionalDataSource
import org.itstep.liannoi.androidpaging.application.ApplicationDefaults
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.storage.core.paging.PagingDetails
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.queries.ListQuery

class UsersPagingDataSource constructor(
    private val usersRepository: UsersRepository
) : PositionalDataSource<User>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<User>) {
        val startPosition: Int = params.requestedStartPosition
        val itemsPerPage: Int = params.requestedLoadSize
        val query = ListQuery(PagingDetails(startPosition, itemsPerPage))

        usersRepository.getAll(query, object : ListQuery.Handler {
            override fun onUsersFetchedSuccess(users: List<User>) {
                Log.d(TAG, "onUsersFetchedSuccess: startPosition - $startPosition")
                Log.d(TAG, "onUsersFetchedSuccess: loadSize - $itemsPerPage")
                callback.onResult(users, ApplicationDefaults.PAGING_START_POSITION)
            }

            override fun onUsersFetchedError(exception: String) {
                /* no-op */
            }
        })
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<User>) {
        val startPosition: Int = params.startPosition
        val itemsPerPage: Int = params.loadSize
        val query = ListQuery(PagingDetails(startPosition, itemsPerPage))

        usersRepository.getAll(query, object : ListQuery.Handler {
            override fun onUsersFetchedSuccess(users: List<User>) {
                Log.d(TAG, "onUsersFetchedSuccess: startPosition - $startPosition")
                Log.d(TAG, "onUsersFetchedSuccess: loadSize - $itemsPerPage")
                callback.onResult(users)
            }

            override fun onUsersFetchedError(exception: String) {
                /* no-op */
            }
        })
    }

    companion object {
        private val TAG: String = this::class.simpleName!!
    }
}