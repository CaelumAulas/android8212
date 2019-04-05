package br.com.caelum.casadocodigo.modelo

import com.google.gson.annotations.SerializedName

data class Livro(
    @SerializedName("nomeLivro") val nome: String,
    @SerializedName("imagemUrl") val foto: String = "",
    @SerializedName("dataPublicacao") val data: String = "04/04/2019",
    @SerializedName("isbn") val isbn: String = "",
    val autores: List<Autor> = emptyList(),
    @SerializedName("valorFisico") val precoFisico: Double = 0.0,
    @SerializedName("valorVirtual") val precoEbook: Double = 0.0,
    @SerializedName("valorVirtualComFisico") val precoAmbos: Double = 0.0,
    val numeroPaginas: Int = 1,
    @SerializedName("descricaoLivro") val descricao: String = ""
)