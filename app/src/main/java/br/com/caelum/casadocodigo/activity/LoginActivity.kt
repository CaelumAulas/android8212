package br.com.caelum.casadocodigo.activity

import android.content.Intent
import android.os.Bundle
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
            val (email, senha) = getInfosDaTela()
            authentication
                .createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        vaiParaCatalogo()
                    }
                }
        }

        login_logar.setOnClickListener {
            val (email, senha) = getInfosDaTela()

            authentication
                .signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        vaiParaCatalogo()
                    }
                }
        }
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