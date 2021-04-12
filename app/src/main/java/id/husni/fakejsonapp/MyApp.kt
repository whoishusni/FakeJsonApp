package id.husni.fakejsonapp

import android.app.Application
import id.husni.fakejsonapp.di.networkModule
import id.husni.fakejsonapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                listOf(
                    networkModule,
                    viewModelModule
                )
            )
        }
    }
}