package com.worldcup.almondial.base

import android.app.Application
import com.worldcup.almondial.Repository
import com.worldcup.almondial.database.RoomDatabase
import com.worldcup.almondial.database.getDatabase
import com.worldcup.almondial.utils.ContextProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainApplication : Application() {

    val database by lazy { getDatabase(this) }
    val repository by lazy { Repository(database as RoomDatabase) }

    val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        ContextProvider.initialize(applicationContext)

    }
}