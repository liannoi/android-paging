package org.itstep.liannoi.androidpaging.application.storage.users

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository
import org.itstep.liannoi.androidpaging.application.common.storage.LocalDataSource
import org.itstep.liannoi.androidpaging.application.storage.users.commands.CreateCommand
import org.itstep.liannoi.androidpaging.application.storage.users.commands.DeleteCommand
import org.itstep.liannoi.androidpaging.application.storage.users.commands.UpdateCommand
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.application.storage.users.queries.DetailQuery
import org.itstep.liannoi.androidpaging.application.storage.users.queries.ListQuery
import org.itstep.liannoi.androidpaging.application.storage.users.sources.UsersRemoteDataSource

class DefaultUsersRepository constructor(
    private val usersLocalDataSource: LocalDataSource<User, Int>,
    private val usersRemoteDataSource: UsersRemoteDataSource? = null
) : UsersRepository {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun create(request: CreateCommand, handler: CreateCommand.Handler) {
        /* no-op */
    }

    override fun getAll(request: ListQuery, handler: ListQuery.Handler) {
        usersLocalDataSource.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { handler.onUsersFetchedSuccess(it) },
                { handler.onUsersFetchedError(it.message.toString()) }
            ).follow()
    }

    override fun getById(request: DetailQuery, handler: DetailQuery.Handler) {
        /* no-op */
    }

    override fun update(request: UpdateCommand, handler: UpdateCommand.Handler) {
        /* no-op */
    }

    override fun delete(request: DeleteCommand, handler: DeleteCommand.Handler) {
        /* no-op */
    }

    ///////////////////////////////////////////////////////////////////////////
    // Disposable
    ///////////////////////////////////////////////////////////////////////////

    override fun stop() {
        disposable.clear()
    }

    override fun destroy() {
        disposable.dispose()
    }

    private fun Disposable.follow() {
        disposable.add(this)
    }
}
