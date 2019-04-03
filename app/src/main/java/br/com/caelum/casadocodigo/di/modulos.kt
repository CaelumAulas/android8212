package br.com.caelum.casadocodigo.di

import br.com.caelum.casadocodigo.repositorio.LivroRepository
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


private val repositories = module {
    single { LivroRepository() }

}

private val viewmodels = module {

    viewModel { LivroViewModel(get()) }

}

val modulos = arrayListOf(repositories, viewmodels)