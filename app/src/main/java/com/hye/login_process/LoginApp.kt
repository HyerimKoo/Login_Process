package com.hye.login_process

import android.app.Application
import timber.log.Timber
import timber.log.Timber.Tree


class LoginApp:Application() {

    override fun onCreate() {
        super.onCreate()
        //팀버 사용위해 추가
        Timber.plant(DebugLogTree() as Tree)
    }

}