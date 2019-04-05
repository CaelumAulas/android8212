package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.adapter.LivroAdapter
import br.com.caelum.casadocodigo.adapter.LivroAdapter.LivroListener
import br.com.caelum.casadocodigo.modelo.Livro
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import kotlinx.android.synthetic.main.lista_fragment.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ListaDeLivrosFragment : Fragment(), LivroListener {

    private val viewModel: LivroViewModel by sharedViewModel()


    override fun onResume() {
        super.onResume()

        val activity = activity as AppCompatActivity

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        activity.supportActionBar?.title = "Catalogo"
        activity.supportActionBar?.subtitle = ""

        viewModel.buscaLivros()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.lista_fragment, container, false)

        viewModel.pegaLivros().observe(this, Observer { lista ->

            view.listaLivros.adapter = LivroAdapter(lista, this)
            view.listaLivros.layoutManager = LinearLayoutManager(context)
        })



        return view
    }

    override fun onClick(livro: Livro) {
        viewModel.seleciona(livro)
    }

}