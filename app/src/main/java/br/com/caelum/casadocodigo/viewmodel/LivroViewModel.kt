package br.com.caelum.casadocodigo.viewmodel

import androidx.lifecycle.ViewModel
import br.com.caelum.casadocodigo.repositorio.LivroRepository

class LivroViewModel(private val repository: LivroRepository) : ViewModel() {

    fun pegaLivros() = repository.getLista()

}