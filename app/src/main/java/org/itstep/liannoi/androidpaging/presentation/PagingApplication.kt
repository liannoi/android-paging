package org.itstep.liannoi.androidpaging.presentation

import android.app.Application
import org.itstep.liannoi.androidpaging.ServiceLocator
import org.itstep.liannoi.androidpaging.application.common.interfaces.UsersRepository

class PagingApplication : Application() {

    val usersRepository: UsersRepository
        get() = ServiceLocator.provideUsersRepository(this)
}
