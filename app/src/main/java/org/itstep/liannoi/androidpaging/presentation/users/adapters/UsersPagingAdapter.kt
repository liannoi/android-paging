package org.itstep.liannoi.androidpaging.presentation.users.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.databinding.ItemUserBinding
import org.itstep.liannoi.androidpaging.presentation.users.UsersDiffCallback
import org.itstep.liannoi.androidpaging.presentation.users.UsersViewModel

class UsersPagingAdapter constructor(
    private val viewModel: UsersViewModel
) : PagedListAdapter<User, UsersPagingAdapter.ViewHolder>(UsersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, getItem(position) ?: return)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Nested classes
    ///////////////////////////////////////////////////////////////////////////

    class ViewHolder private constructor(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: UsersViewModel, user: User) {
            binding.viewmodel = viewModel
            binding.user = user
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder = ViewHolder(
                ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}
