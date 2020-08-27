package org.itstep.liannoi.androidpaging.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.storage.seeding.SeedingCommand
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.queries.ListQuery

class UsersViewModel constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> = _users

    init {
        SeedingCommand.Handler(usersRepository, disposable).handle(SeedingHandler())
    }

    ///////////////////////////////////////////////////////////////////////////
    // Disposable
    ///////////////////////////////////////////////////////////////////////////

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
        disposable.dispose()
        usersRepository.stop()
        usersRepository.destroy()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Nested classes
    ///////////////////////////////////////////////////////////////////////////

    private inner class ListQueryHandler : ListQuery.Handler {

        override fun onUsersFetchedSuccess(users: List<User>) {
            this@UsersViewModel._users.value = users
        }

        override fun onUsersFetchedError(exception: String) {
            /* no-op */
        }
    }

    private inner class SeedingHandler : SeedingCommand.Callback {

        override fun onSeedingSuccess() {
            usersRepository.getAll(ListQuery(), ListQueryHandler())
        }
    }
}
