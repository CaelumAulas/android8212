package br.com.caelum.casadocodigo.di

import br.com.caelum.casadocodigo.modelo.Carrinho
import br.com.caelum.casadocodigo.repositorio.LivroRepository
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import br.com.caelum.casadocodigo.webservices.InicializadorDoRetrofit
import br.com.caelum.casadocodigo.webservices.LivroApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


private val modelos = module {

    single { Carrinho() }
}

private val webservices = module {

    factory { InicializadorDoRetrofit().retrofit }

    factory { LivroApi(get()) }
}

private val repositories = module {
    single { LivroRepository(get()) }

}

private val viewmodels = module {

    viewModel { LivroViewModel(get()) }

}

val modulos = arrayListOf(modelos, webservices, repositories, viewmodels)