package org.itstep.liannoi.androidpaging.presentation.common.extensions

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import org.itstep.liannoi.androidpaging.ServiceLocator
import org.itstep.liannoi.androidpaging.application.ApplicationDefaults
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.presentation.common.executors.DefaultExecutor
import org.itstep.liannoi.androidpaging.presentation.users.paging.UsersPagingAdapter
import org.itstep.liannoi.androidpaging.presentation.users.paging.UsersPagingDataSource
import java.util.concurrent.Executors

fun setupUsersPaging(): PagedList<User> {
    val config: PagedList.Config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(ApplicationDefaults.PAGING_INITIAL_SIZE)
        .setPageSize(ApplicationDefaults.PAGING_ITEMS_PER_PAGE)
        .build()

    return PagedList.Builder(UsersPagingDataSource(ServiceLocator.usersRepository!!), config)
        .setFetchExecutor(Executors.newSingleThreadExecutor())
        .setNotifyExecutor(DefaultExecutor())
        .build()
}

@BindingAdapter("app:items")
fun RecyclerView.adapt(items: List<User>?) {
    (adapter as UsersPagingAdapter).submitList(setupUsersPaging())
}

/**
 * Past version
 *
 * @BindingAdapter("app:items")
 * fun RecyclerView.adapt(items: List<User>?) {
 *     items?.let { (adapter as UsersAdapter).submitList(items) }
 * }
 */
