package com.example.libraryapi.controller.dto;

import com.example.libraryapi.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(
        UUID id,

        @NotBlank(message = "campo obrigatório")
        @Size(min = 2, max = 100, message = "O campo deve possuir um tamanho entre 2 e 100 caracteres")
        String nome,

        @NotNull(message = "campo obrigatório")
        LocalDate dataNascimento,

        @NotBlank(message = "campo obrigatório")
        @Size(min = 2, max = 100, message = "O campo deve possuir um tamanho entre 2 e 100 caracteres")
        String nacionalidade) {


    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setId(this.id);
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
