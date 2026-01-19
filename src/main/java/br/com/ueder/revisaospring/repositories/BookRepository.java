package br.com.ueder.revisaospring.repositories;

import br.com.ueder.revisaospring.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b join fetch b.author ")
    List<Book> findAll();
}
