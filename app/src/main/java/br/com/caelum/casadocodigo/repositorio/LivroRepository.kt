package br.com.caelum.casadocodigo.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.caelum.casadocodigo.modelo.Livro
import br.com.caelum.casadocodigo.webservices.LivroApi

class LivroRepository(private val api: LivroApi) {

    private val livros = MutableLiveData<ArrayList<Livro>>()

    fun getLivros() = livros as LiveData<ArrayList<Livro>>

    fun buscaLivros() = api.buscaLivros { lista: ArrayList<Livro> ->

        livros.postValue(lista)
    }
}