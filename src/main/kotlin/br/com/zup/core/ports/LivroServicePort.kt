package br.com.zup.core.ports

import br.com.zup.core.model.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
interface LivroServicePort {
    fun getAll(): List<Livro>
    fun getById(id: UUID): Livro?
}