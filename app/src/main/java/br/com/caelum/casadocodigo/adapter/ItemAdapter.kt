package br.com.caelum.casadocodigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.adapter.ItemViewHolder.*
import br.com.caelum.casadocodigo.modelo.Item
import br.com.caelum.casadocodigo.modelo.TipoDeLivro
import com.squareup.picasso.Picasso

class ItemAdapter(private val itens: List<Item>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun getItemCount(): Int = itens.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == 1) {
            val view = inflater.inflate(R.layout.item_livro_fisico, parent, false)
            return ItemFisicoVH(view)
        } else if (viewType == 2) {
            val view = inflater.inflate(R.layout.item_livro_virtual, parent, false)
            return ItemVirtualVH(view)
        } else {
            val view = inflater.inflate(R.layout.item_livro_ambos, parent, false)
            return ItemAmbosVH(view)
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itens[position]
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        val item = itens[position]
        when (item.tipo) {
            TipoDeLivro.FISICO -> return 1
            TipoDeLivro.VIRTUAL -> return 2
            TipoDeLivro.AMBOS -> return 3
        }
    }
}

sealed class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    internal val itemPreco: TextView = view.findViewById(R.id.itemPreco)
    private val itemNome: TextView = view.findViewById(R.id.itemNome)
    private val itemFoto: ImageView = view.findViewById(R.id.itemFoto)

    open fun bind(item: Item) {
        itemNome.text = item.livro.nome

        var url = item.livro.foto

        if (url.startsWith("http:")) {
            url = url.replace("http:", "https:")
        }

        Picasso.get().load(url).fit().into(itemFoto)
    }

    class ItemFisicoVH(view: View) : ItemViewHolder(view) {

        private val itemISBN: TextView = view.findViewById(R.id.itemISBN)

        override fun bind(item: Item) {
            super.bind(item)

            itemISBN.text = item.livro.isbn
            itemPreco.text = "R$ ${item.livro.precoFisico}"

        }
    }

    class ItemVirtualVH(view: View) : ItemViewHolder(view) {

        private val itemAutores: TextView = view.findViewById(R.id.itemAutores)

        override fun bind(item: Item) {
            super.bind(item)

            itemAutores.text = "${item.livro.autores.map { autor -> autor.nome }}"
            itemPreco.text = "R$ ${item.livro.precoEbook}"

        }
    }

    class ItemAmbosVH(view: View) : ItemViewHolder(view) {

        private val itemDataPub: TextView = view.findViewById(R.id.itemDataPub)

        override fun bind(item: Item) {
            super.bind(item)

            itemDataPub.text = item.livro.data
            itemPreco.text = "R$ ${item.livro.precoAmbos}"

        }
    }


}
