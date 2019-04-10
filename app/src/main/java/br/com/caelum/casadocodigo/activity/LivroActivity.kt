package br.com.caelum.casadocodigo.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.fragment.CarregandoFragment
import br.com.caelum.casadocodigo.fragment.DetalhesDoLivroFragment
import br.com.caelum.casadocodigo.fragment.ListaDeLivrosFragment
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.viewmodel.ext.android.viewModel

class LivroActivity : AppCompatActivity() {

    private val viewModel: LivroViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)

        exibe(CarregandoFragment())


        viewModel.pegaLivros().observe(this, Observer {

            exibe(ListaDeLivrosFragment())
        })

        viewModel.getLivroSelecionado().observe(this, Observer { livro ->

            if (livro != null) {
                exibe(DetalhesDoLivroFragment(), true)
            }
        })


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        if (item.itemId == R.id.menuCarrinho) {
            val intent = Intent(this, CarrinhoActivity::class.java)

            startActivity(intent)
        }


        if (item.itemId == R.id.menuSair) {

            FirebaseAuth.getInstance().signOut()

            finish()
            startActivity(Intent(this, LoginActivity::class.java))

        }

        return true
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
