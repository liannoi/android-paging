package org.itstep.liannoi.androidpaging.application.storage.users.queries

import org.itstep.liannoi.androidpaging.application.storage.core.paging.PagingDetails
import org.itstep.liannoi.androidpaging.application.storage.users.models.User

class ListQuery constructor(
    val pagingDetails: PagingDetails
) {

    interface Handler {

        fun onUsersFetchedSuccess(users: List<User>)

        // TODO: 26.08.2020 Replace with custom exception
        fun onUsersFetchedError(exception: String)
    }
}
