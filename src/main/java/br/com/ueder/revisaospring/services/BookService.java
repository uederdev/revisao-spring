package br.com.ueder.revisaospring.services;

import br.com.ueder.revisaospring.dtos.BookDTO;
import br.com.ueder.revisaospring.exceptions.ObjectNotFoundException;
import br.com.ueder.revisaospring.models.Book;
import br.com.ueder.revisaospring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.valueOf(id) ));
    }

    public List<BookDTO> findAll() {
        return repository.findAll().stream().map(Book::toDTO).toList();
    }

    @Transactional
    public Book save(Book book) {
        return repository.save(book);
    }
}
