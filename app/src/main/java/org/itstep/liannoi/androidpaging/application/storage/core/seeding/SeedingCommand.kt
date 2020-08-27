package org.itstep.liannoi.androidpaging.application.storage.core.seeding

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository

class SeedingCommand {

    class Handler constructor(
        private val usersRepository: UsersRepository,
        private val disposable: CompositeDisposable
    ) {

        fun handle(callback: Callback) {
            val subscribe = Completable.fromAction { SampleDataSeeder(usersRepository).seedAll() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { callback.onSeedingSuccess() }

            disposable.add(subscribe)
        }
    }

    interface Callback {

        fun onSeedingSuccess()
    }
}
