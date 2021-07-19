package br.com.zup.entrypoint.dto

import java.util.*

data class LivroDto (
    val id: UUID? = null,
    val nome: String = "",
    val nomeAutor: String = "",
    val anoDePublicacao: String = "",
    )