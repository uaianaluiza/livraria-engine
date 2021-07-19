package br.com.zup.core.ports

import br.com.zup.database.entity.LivroEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface LivroRepository {
    fun getAll(): List<LivroEntity>
    fun getById(id: UUID): LivroEntity?
}