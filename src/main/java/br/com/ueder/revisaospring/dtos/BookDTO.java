package br.com.ueder.revisaospring.dtos;

import br.com.ueder.revisaospring.models.Author;
import br.com.ueder.revisaospring.models.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BookDTO(
        Long id,
        @NotBlank
        String name,
        @Min(value = 1)
        Integer pages,
        @Min(value = 1)
        Integer chapters,
        @NotBlank
        String isbn,
        @NotBlank
        String publishedName,
        @Valid
        @JsonIgnore
        Author author
        ) {

        public Book toModel(){
                Book book = new Book(name(), pages(), chapters(), isbn(), publishedName(), author());
                book.setId(id());
                return book;
        }
}
