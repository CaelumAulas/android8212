package br.com.caelum.casadocodigo.repositorio

import br.com.caelum.casadocodigo.modelo.Livro

class LivroRepository {

    fun getLista(): ArrayList<Livro> {
        return arrayListOf(
            Livro("Java"),
            Livro("Kotlin"),
            Livro("Swift"),
            Livro("Java"),
            Livro("Kotlin"),
            Livro("Swift"),
            Livro("Java"),
            Livro("Kotlin"),
            Livro("Swift"),
            Livro("Java"),
            Livro("Kotlin"),
            Livro("Swift")
        )
    }
}