package br.com.ueder.revisaospring.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ueder.revisaospring.dtos.BookDTO;
import br.com.ueder.revisaospring.dtos.BookListDTO;
import br.com.ueder.revisaospring.models.Book;
import br.com.ueder.revisaospring.services.BookService;
import br.com.ueder.revisaospring.utils.Util;

@RestController
@RequestMapping("/apis/v1/books")
public class BooksController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookListDTO>> getAll() {
        List<BookListDTO> books = service.findAll()
                .stream()
                .map(BookListDTO::listDTO)
                .toList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(Long.valueOf(id)).toDTO());
    }

    @PostMapping
    public ResponseEntity<BookDTO> save(@RequestBody @Validated Book book, UriComponentsBuilder builder) {
        Book bookSaved = service.save(book);
        URI uri = Util.getUri(bookSaved, "/apis/v1/books/{id}");
        return ResponseEntity.created(uri).body(bookSaved.toDTO());
    }
}
