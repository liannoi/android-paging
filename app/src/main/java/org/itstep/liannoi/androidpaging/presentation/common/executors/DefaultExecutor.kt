package org.itstep.liannoi.androidpaging.presentation.common.executors

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class DefaultExecutor : Executor {

    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun execute(runnable: Runnable) {
        handler.post(runnable)
    }
}
