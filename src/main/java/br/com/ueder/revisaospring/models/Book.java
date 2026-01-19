package br.com.ueder.revisaospring.models;

import br.com.ueder.revisaospring.dtos.BookDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Integer pages;
    @Column(nullable = false)
    private Integer chapters;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false, unique = true)
    private String publishedName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE })
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String name, Integer pages, Integer chapters, String isbn, String publishedName, Author author) {
        this.name = name;
        this.pages = pages;
        this.chapters = chapters;
        this.isbn = isbn;
        this.publishedName = publishedName;
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getChapters() {
        return chapters;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublishedName() {
        return publishedName;
    }

    public Author getAuthor() {
        return author;
    }

    public BookDTO toDTO() {
        return new BookDTO(id, name, pages, chapters, isbn, publishedName, author );
    }
}
