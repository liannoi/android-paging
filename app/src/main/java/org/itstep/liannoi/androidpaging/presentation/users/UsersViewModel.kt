package org.itstep.liannoi.androidpaging.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.queries.ListQuery

class UsersViewModel constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> = _users

    init {
        loadUsers()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Disposable
    ///////////////////////////////////////////////////////////////////////////

    override fun onCleared() {
        super.onCleared()
        usersRepository.stop()
        usersRepository.destroy()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun loadUsers() {
        usersRepository.getAll(ListQuery(), ListQueryHandler())
    }

    ///////////////////////////////////////////////////////////////////////////
    // Nested classes
    ///////////////////////////////////////////////////////////////////////////

    private inner class ListQueryHandler : ListQuery.Handler {

        override fun onUsersFetchedSuccess(users: List<User>) {
            _users.value = users
        }

        override fun onUsersFetchedError(exception: String) {
            /* no-op */
        }
    }
}
