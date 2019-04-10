package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CarregandoFragment : Fragment() {

    private val viewModel: LivroViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.buscaLivros()

        return inflater.inflate(R.layout.carregando_fragment, container, false)
    }
}