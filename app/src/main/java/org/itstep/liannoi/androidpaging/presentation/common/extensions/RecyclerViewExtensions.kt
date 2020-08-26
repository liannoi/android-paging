package org.itstep.liannoi.androidpaging.presentation.common.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.presentation.users.UsersAdapter

@BindingAdapter("app:items")
fun RecyclerView.adapt(items: List<User>?) {
    items?.let { (adapter as UsersAdapter).submitList(items) }
}
