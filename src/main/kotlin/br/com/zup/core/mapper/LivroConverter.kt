package br.com.zup.core.mapper

import br.com.zup.core.model.Livro
import br.com.zup.database.entity.LivroEntity
import br.com.zup.entrypoint.dto.LivroDto
import java.util.stream.Collectors

class LivroConverter {
    companion object{
        fun toTransformlivroEntityToLivro(livroEntity: LivroEntity) =
            Livro(
                livroEntity.id,
                livroEntity.nome,
                livroEntity.nomeAutor,
                livroEntity.anoDePublicacao
            )

        fun toTransformlivroToLivroDto(livro: Livro) =
            LivroDto(
                livro.id,
                livro.nome,
                livro.nomeAutor,
                livro.anoDePublicacao
            )

        fun livroEntityListToLivroList(livroEntity: List<LivroEntity>) =
            livroEntity.stream().map { livro ->
                Livro(livro.id, livro.nome,livro.nomeAutor,livro.anoDePublicacao)
            }.collect(Collectors.toList())

        fun livroListToLivroDtoList(livroList: List<Livro>) =
            livroList.stream().map { livro ->
                LivroDto(livro.id,livro.nome,livro.nomeAutor,livro.anoDePublicacao)
            }.collect(Collectors.toList())
    }
}