package br.com.caelum.casadocodigo.application

import android.app.Application
import br.com.caelum.casadocodigo.di.modulos
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CasaDoCodigoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(modulos)
            androidContext(this@CasaDoCodigoApplication)
        }
    }
}