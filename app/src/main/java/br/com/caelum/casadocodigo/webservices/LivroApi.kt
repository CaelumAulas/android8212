package br.com.caelum.casadocodigo.webservices

import br.com.caelum.casadocodigo.modelo.Livro
import br.com.caelum.casadocodigo.webservices.respostas.LivroResposta
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

class LivroApi(retrofit: Retrofit) {

    private val livroService: LivroService by lazy {
        retrofit.create(LivroService::class.java)
    }

    fun buscaLivros(
        sucesso: (ArrayList<Livro>) -> Unit
    ) {

        val chamadaProServidor = livroService.buscaLivrosNaApi()

        chamadaProServidor.enqueue(object : Callback<LivroResposta> {
            override fun onFailure(call: Call<LivroResposta>, t: Throwable) {

            }

            override fun onResponse(call: Call<LivroResposta>, response: Response<LivroResposta>) {

                response.body()?.let { livroResposta ->

                    sucesso(livroResposta.livros)


                }
            }
        })
    }
    interface LivroService {

        @GET("/listarLivros?indicePrimeiroLivro=0&qtdLivros=20")
        fun buscaLivrosNaApi(): Call<LivroResposta>
    }

}