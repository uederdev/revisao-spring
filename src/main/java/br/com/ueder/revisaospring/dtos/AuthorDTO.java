package br.com.ueder.revisaospring.dtos;

import br.com.ueder.revisaospring.models.Author;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AuthorDTO(
        Long id,
        @NotBlank
        String name,
        @Min(value = 0)
        Integer age
) {

        public Author toModel(){
                Author author = new Author(name(), age());
                author.setId(id());
                return author;
        }
}
