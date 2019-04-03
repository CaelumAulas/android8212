package br.com.caelum.casadocodigo.modelo

data class Livro(
    val nome: String,
    val foto: String = "",
    val data: String = "",
    val isbn: String = "",
    val autores: List<Autor> = emptyList(),
    val precoFisico: Double = 0.0,
    val precoEbook: Double = 0.0,
    val precoAmbos: Double = 0.0,
    val numeroPaginas: Int = 1,
    val descricao: String = ""
)