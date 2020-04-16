package ua.turskyi.expandedrecyclerview.utils

import android.content.Context

class Utils private constructor() {
    companion object {
        private var context: Context? = null

        fun init(context: Context) {
            Companion.context = context.applicationContext
        }

        /**
         * ApplicationContext
         * @return ApplicationContext
         */
        fun getContext(): Context? {
            if (context != null) return context
            throw NullPointerException("u should init first")
        }
    }

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }
}
