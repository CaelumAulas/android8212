package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Livro
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import kotlinx.android.synthetic.main.detalhes_fragment.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DetalhesDoLivroFragment : Fragment() {


    private val viewModel: LivroViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.detalhes_fragment, container, false)

        val livro = viewModel.getLivroSelecionado().value!!

        view.nome_livro_detalhes.text = livro.nome

        view.data_pub_livro_detalhe.text = livro.data

        view.desc_livro_detalhe.text = livro.descricao

        view.autores_livro_detalhes.text = "${livro.autores.map { autor -> autor.nome }}"

        view.num_pag_livro_detalhe.text = livro.numeroPaginas.toString()

        view.livro_isbn_detalhe.text = livro.isbn


        return view
    }
}