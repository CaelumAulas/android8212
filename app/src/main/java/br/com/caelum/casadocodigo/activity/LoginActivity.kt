package br.com.caelum.casadocodigo.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.casadocodigo.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var authentication: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authentication = FirebaseAuth.getInstance()


        if (authentication.currentUser != null) {
            vaiParaCatalogo()
        }

        login_novo.setOnClickListener {

            mudaEstadoDoBotao(login_novo, Color.GRAY, "Criando usuario")

            val (email, senha) = getInfosDaTela()
            authentication
                .createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        vaiParaCatalogo()
                    } else {
                        mudaEstadoDoBotao(login_novo, Color.parseColor("#ff9b19"), "Criar Usuario")
                        Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }

        login_logar.setOnClickListener {

            mudaEstadoDoBotao(login_logar, Color.GRAY, "Logando usuario")

            val (email, senha) = getInfosDaTela()

            authentication
                .signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        vaiParaCatalogo()
                    } else {
                        mudaEstadoDoBotao(login_logar, Color.parseColor("#ff9b19"), "Entrar")
                        Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun mudaEstadoDoBotao(botao: Button, color: Int, texto: String) {
        botao.setBackgroundColor(color)
        botao.text = texto
    }

    private fun getInfosDaTela(): Pair<String, String> {
        val email = login_email.text.toString()
        val senha = login_senha.text.toString()
        return Pair(email, senha)
    }

    private fun vaiParaCatalogo() {
        val intent = Intent(this, LivroActivity::class.java)
        startActivity(intent)

        finish()
    }
}