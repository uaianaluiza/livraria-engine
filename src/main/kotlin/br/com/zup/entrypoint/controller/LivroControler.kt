package br.com.zup.entrypoint.controller

import br.com.zup.core.model.Livro
import br.com.zup.core.service.LivroServiceImpl
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.awt.PageAttributes
import java.util.*

@Controller("/livros")
class LivroControler (private val livroService: LivroServiceImpl) {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getLivros():HttpResponse<List<Livro?>> =
        HttpResponse.ok(HttpStatus.OK).body(this.livroService.getAll())

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getLivroById(@PathVariable id: UUID): HttpResponse<Livro> =
        HttpResponse.ok(HttpStatus.OK).body(this.livroService.getById(id))
}