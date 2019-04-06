package br.com.caelum.casadocodigo.modelo

import br.com.caelum.casadocodigo.modelo.TipoDeLivro.*

sealed class Item(
    val livro: Livro,
    private val tipo: TipoDeLivro
) {

    fun getValor(): Double = when (tipo) {
        AMBOS -> livro.precoAmbos
        VIRTUAL -> livro.precoEbook
        FISICO -> livro.precoFisico
    }


    class ItemFisico(livro: Livro) : Item(livro, FISICO)
    class ItemVirtual(livro: Livro) : Item(livro, VIRTUAL)
    class ItemJuntos(livro: Livro) : Item(livro, AMBOS)

}


enum class TipoDeLivro {
    AMBOS, VIRTUAL, FISICO
}