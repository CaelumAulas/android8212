package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.casadocodigo.modelo.Carrinho
import org.koin.android.ext.android.inject

class CarrinhoActivity : AppCompatActivity() {

    private val carrinho: Carrinho by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.subtitle = "R$ ${carrinho.valorTotal()}"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }

        return true
    }
}