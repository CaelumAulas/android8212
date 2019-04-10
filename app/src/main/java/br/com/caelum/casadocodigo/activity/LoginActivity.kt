package br.com.caelum.casadocodigo.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.casadocodigo.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var authentication: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authentication = FirebaseAuth.getInstance()

        login_novo.setOnClickListener {
            val email = login_email.text.toString()
            val senha = login_senha.text.toString()
            authentication
                .createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {

                        if (task.isSuccessful) {
                            vaiParaCatalogo()
                        }
                    }
                })
        }
    }

    private fun vaiParaCatalogo() {
        val intent = Intent(this, LivroActivity::class.java)
        startActivity(intent)

        finish()
    }
}