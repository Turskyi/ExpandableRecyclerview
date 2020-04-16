package ua.turskyi.expandedrecyclerview

import android.app.Application
import ua.turskyi.expandedrecyclerview.utils.Utils

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        Utils.init(this)
    }

    companion object {
        var instance: MyApplication? = null
            private set
    }
}