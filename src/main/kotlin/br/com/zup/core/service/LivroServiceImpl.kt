package br.com.zup.core.service

import br.com.zup.core.mapper.LivroConverter
import br.com.zup.core.model.Livro
import br.com.zup.core.ports.LivroRepository
import br.com.zup.core.ports.LivroServicePort
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceImpl (private val livroRepository: LivroRepository) : LivroServicePort{

    override fun getAll(): List<Livro> =
        LivroConverter.livroEntityListToLivroList(livroRepository.getAll())

    override fun getById(id: UUID): Livro? =
        LivroConverter.toTransformlivroEntityToLivro(livroRepository.getById(id)!!)

}
