package org.itstep.liannoi.androidpaging.presentation.common.extensions

import androidx.fragment.app.Fragment
import org.itstep.liannoi.androidpaging.presentation.PagingApplication
import org.itstep.liannoi.androidpaging.presentation.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory =
    ViewModelFactory((requireContext().applicationContext as PagingApplication).usersRepository)
