package br.com.caelum.casadocodigo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Livro
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_livro.view.*
import java.lang.Exception

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

        val foto = view.itemLivroImagem

        fun bind(livro: Livro) {

            nomeLivro.text = livro.nome


            val picasso = Picasso.get()

            picasso.setIndicatorsEnabled(true)

            var url = livro.foto

            if (url.startsWith("http:")) {
                url = url.replace("http:", "https:")
            }

            picasso.load(url).fit().into(foto, object : Callback {
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {
                    picasso.load(android.R.drawable.ic_dialog_alert).into(foto)
                }
            })

            view.setOnClickListener {
                listener.onClick(livro)
            }

        }
    }

    interface LivroListener {


        fun onClick(livro: Livro)

    }
}
