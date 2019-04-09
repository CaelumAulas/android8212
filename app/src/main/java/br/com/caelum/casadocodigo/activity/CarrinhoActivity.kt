package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.adapter.ItemAdapter
import br.com.caelum.casadocodigo.modelo.Carrinho
import kotlinx.android.synthetic.main.activity_carrinho.*
import org.koin.android.ext.android.inject

class CarrinhoActivity : AppCompatActivity() {

    private val carrinho: Carrinho by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        supportActionBar?.subtitle = "R$ ${carrinho.valorTotal()}"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listaItens.adapter = ItemAdapter(carrinho.getLista())
        listaItens.layoutManager = LinearLayoutManager(this)

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