package app.practice.practicecleanarchitecturetmdbclient

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
    }

}