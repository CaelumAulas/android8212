package br.com.caelum.casadocodigo.application

import android.app.Application
import br.com.caelum.casadocodigo.di.modulos
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CasaDoCodigoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

        startKoin {
            modules(modulos)
            androidContext(this@CasaDoCodigoApplication)
        }
    }
}