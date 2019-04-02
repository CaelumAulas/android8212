package br.com.caelum.casadocodigo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.caelum.casadocodigo.fragment.ListaDeLivrosFragment

class LivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ListaDeLivrosFragment())
        transaction.commit()

    }
}
