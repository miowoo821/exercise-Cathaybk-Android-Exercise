package com.tpower.cathaybk.rx.scheduler


/* Created on 2022/5/10 */

object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}