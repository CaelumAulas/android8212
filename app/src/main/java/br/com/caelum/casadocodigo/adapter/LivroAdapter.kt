package br.com.caelum.casadocodigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Livro
import kotlinx.android.synthetic.main.item_livro.view.*

class LivroAdapter(
    val lista: ArrayList<Livro>,
    val listener: LivroListener
) : RecyclerView.Adapter<LivroAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.item_livro, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val livro = lista[position]

        holder.bind(livro)

    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nomeLivro = view.itemLivroNome


        fun bind(livro: Livro) {

            nomeLivro.text = livro.nome

            view.setOnClickListener {
                listener.onClick(livro)
            }

        }
    }

    interface LivroListener {


        fun onClick(livro: Livro)

    }
}
