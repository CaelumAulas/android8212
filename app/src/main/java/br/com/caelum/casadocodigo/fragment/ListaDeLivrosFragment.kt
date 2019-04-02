package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.adapter.LivroAdapter
import br.com.caelum.casadocodigo.modelo.Livro
import kotlinx.android.synthetic.main.lista_fragment.view.*

class ListaDeLivrosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_fragment, container, false)

        val lista = arrayListOf(
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

        view.listaLivros.adapter = LivroAdapter(lista)
        view.listaLivros.layoutManager = LinearLayoutManager(context)

        return view
    }
}