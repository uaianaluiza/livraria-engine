package br.com.zup.database.entity

import java.util.*

data class LivroEntity (
    val id: UUID? = null,
    val nome: String = "",
    val nomeAutor: String = "",
    val anoDePublicacao: String = "",
        )