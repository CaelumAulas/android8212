package br.com.caelum.casadocodigo.webservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InicializadorDoRetrofit {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://cdcmob.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}