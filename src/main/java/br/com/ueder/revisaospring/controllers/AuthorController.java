package br.com.ueder.revisaospring.controllers;

import br.com.ueder.revisaospring.dtos.AuthorDTO;
import br.com.ueder.revisaospring.models.Author;
import br.com.ueder.revisaospring.services.AuthorService;
import br.com.ueder.revisaospring.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/apis/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> save(@Validated @RequestBody AuthorDTO entity){
        Author author = service.save(entity.toModel());
        URI uri = Util.getUri(author.getId(), "/apis/v1/authors/{id}");
        return ResponseEntity.created(uri).body(author.toDTO());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable Long id, @Validated @RequestBody AuthorDTO entity){
        Author author = service.update(id, entity);
        return ResponseEntity.ok(author.toDTO());
    }
}
