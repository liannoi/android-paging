package org.itstep.liannoi.androidpaging.presentation.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.itstep.liannoi.androidpaging.application.storage.users.models.User
import org.itstep.liannoi.androidpaging.databinding.ItemUserBinding

class UsersAdapter constructor(
    private val viewModel: UsersViewModel
) : ListAdapter<User, UsersAdapter.ViewHolder>(UsersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, getItem(position))
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
