package br.com.caelum.casadocodigo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.caelum.casadocodigo.modelo.Livro
import br.com.caelum.casadocodigo.repositorio.LivroRepository

class LivroViewModel(private val repository: LivroRepository) : ViewModel() {

    private val livroLiveData: MutableLiveData<Livro> = MutableLiveData()

    fun getLivroSelecionado() = livroLiveData as LiveData<Livro>

    fun pegaLivros() = repository.getLista()

    fun seleciona(livro: Livro) {
        livroLiveData.postValue(livro)

    }

}