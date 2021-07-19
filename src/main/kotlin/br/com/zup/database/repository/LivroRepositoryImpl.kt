package br.com.zup.database.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import br.com.zup.core.ports.LivroRepository
import br.com.zup.database.entity.LivroEntity
import java.lang.RuntimeException
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRepositoryImpl(private val cqlSession: CqlSession) : LivroRepository {

    override fun getAll(): List<LivroEntity> {
        val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM livraria.Livros",
                )
        )
        return queryResult.map { livro ->
            LivroEntity(
                livro.getUuid("id")!!,
                livro.getString("nome")!!,
                livro.getString("nomeAutor")!!,
                livro.getString("anoDePublicacao")!!,
            )
        }.toList()
    }

    override fun getById(id: UUID): LivroEntity? {
        try {
            val queryResult = cqlSession.execute(
                SimpleStatement
                    .newInstance(
                        "SELECT * FROM livraria.Livros WHERE is =?",
                        id
                    )
            )
            return queryResult.map { livro ->
                LivroEntity(
                    livro.getUuid("id")!!,
                    livro.getString("nome")!!,
                    livro.getString("nomeAutor")!!,
                    livro.getString("anoDePublicacao")!!,
                )
            }.firstOrNull()

        }catch (e: RuntimeException){
            throw RuntimeException()
        }

    }
}