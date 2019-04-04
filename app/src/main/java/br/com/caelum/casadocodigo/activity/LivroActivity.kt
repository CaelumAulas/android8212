package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.fragment.DetalhesDoLivroFragment
import br.com.caelum.casadocodigo.fragment.ListaDeLivrosFragment
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LivroActivity : AppCompatActivity() {

    private val viewModel: LivroViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)

        exibe(ListaDeLivrosFragment())


        viewModel.getLivroSelecionado().observe(this, Observer { livro ->

            if (livro != null) {
                exibe(DetalhesDoLivroFragment(), true)
            }
        })


    }

    private fun exibe(
        fragment: Fragment,
        deveEmpilhar: Boolean = false
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        if (deveEmpilhar) transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onBackPressed() {
        super.onBackPressed()

        viewModel.desmarcaLivro()

    }
}
