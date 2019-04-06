package br.com.caelum.casadocodigo.modelo

import br.com.caelum.casadocodigo.modelo.Item.ItemFisico
import java.util.*

class Carrinho {

    private val itens: MutableList<Item> = ArrayList()

    fun adiciona(item: Item) {
        itens.add(item)
    }

    fun remove(item: Item) {
        itens.remove(item)
    }

    fun getLista() = Collections.unmodifiableList(itens)
}