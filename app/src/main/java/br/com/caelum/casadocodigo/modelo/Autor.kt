package br.com.caelum.casadocodigo.modelo

import com.google.gson.annotations.SerializedName

data class Autor(
    @SerializedName("nomeAutor") val nome: String,
    @SerializedName("detalhesAutor") val descricao: String,
    @SerializedName("imagemAutor") val foto: String
)
