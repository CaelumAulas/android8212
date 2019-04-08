package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Carrinho
import org.koin.android.ext.android.inject

class CarrinhoActivity : AppCompatActivity() {

    private val carrinho: Carrinho by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.subtitle = "R$ ${carrinho.valorTotal()}"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.carrinho_menu, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }

            R.id.finalizar -> {
                carrinho.limpa()
                finish()
                Toast.makeText(this, "Compra realizada com sucesso", Toast.LENGTH_LONG).show()
            }
        }

        return true
    }
}