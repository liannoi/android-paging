package org.itstep.liannoi.androidpaging.presentation.users

import androidx.recyclerview.widget.DiffUtil
import org.itstep.liannoi.androidpaging.application.storage.users.models.User

class UsersDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem == newItem
}
