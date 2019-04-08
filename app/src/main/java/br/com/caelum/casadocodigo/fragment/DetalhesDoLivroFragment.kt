package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Carrinho
import br.com.caelum.casadocodigo.modelo.Item
import br.com.caelum.casadocodigo.modelo.Item.*
import br.com.caelum.casadocodigo.modelo.Livro
import br.com.caelum.casadocodigo.viewmodel.LivroViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detalhes_fragment.view.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DetalhesDoLivroFragment : Fragment() {


    private val viewModel: LivroViewModel by sharedViewModel()
    private val carrinho: Carrinho by inject()

    private lateinit var livro: Livro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        livro = viewModel.getLivroSelecionado().value!!


        val activity = activity as AppCompatActivity

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        activity.supportActionBar?.title = livro.nome
        activity.supportActionBar?.subtitle = livro.data
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.detalhes_fragment, container, false)


        var url = livro.foto

        if (url.startsWith("http:")) {
            url = url.replace("http:", "https:")
        }

        Picasso.get().load(url).fit().into(view.foto_livro_detalhes)

        view.nome_livro_detalhes.text = livro.nome

        view.data_pub_livro_detalhe.text = livro.data

        view.desc_livro_detalhe.text = livro.descricao

        view.autores_livro_detalhes.text = "${livro.autores.map { autor -> autor.nome }}"

        view.num_pag_livro_detalhe.text = livro.numeroPaginas.toString()

        view.livro_isbn_detalhe.text = livro.isbn


        view.btn_comprar_detalhe.setOnClickListener {

            val tipos = inflater.inflate(R.layout.tipos_item, null, false) as RadioGroup

            AlertDialog.Builder(context!!)
                .setView(tipos)
                .setTitle("Qual é o formato que você comprar?")
                .setPositiveButton("Adiciona no Carrinho") { _, _ ->

                    val item = when (tipos.checkedRadioButtonId) {
                        R.id.radioAmbos -> {
                            ItemJuntos(livro)
                        }
                        R.id.radioEbook -> {
                            ItemVirtual(livro)
                        }
                        R.id.radioFisico -> {
                            ItemFisico(livro)
                        }
                        else -> {
                            throw Exception()
                        }
                    }

                    carrinho.adiciona(item)

                    Toast.makeText(context!!, "$item : Item adicionado ao carrinho", Toast.LENGTH_LONG).show()
                    activity?.onBackPressed()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }


        return view
    }
}