package org.itstep.liannoi.androidpaging.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.itstep.liannoi.androidpaging.databinding.FragmentUsersBinding
import org.itstep.liannoi.androidpaging.presentation.common.extensions.getViewModelFactory
import org.itstep.liannoi.androidpaging.presentation.users.paging.UsersPagingAdapter

class UsersFragment : Fragment() {

    private val viewModel: UsersViewModel by viewModels { getViewModelFactory() }
    private lateinit var viewDataBinding: FragmentUsersBinding
    private lateinit var listAdapter: UsersPagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentUsersBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }

        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        setupListAdapter()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun setupListAdapter() {
        listAdapter = UsersPagingAdapter(viewDataBinding.viewmodel ?: return)
        viewDataBinding.usersList.adapter = listAdapter
    }
}
