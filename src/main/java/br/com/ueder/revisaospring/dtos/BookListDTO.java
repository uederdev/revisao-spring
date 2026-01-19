package br.com.ueder.revisaospring.dtos;

public record BookListDTO(Long id,
        String name,
        Integer pages,
        Integer chapters,
        String isbn,
        String publishedName,
        String author) {

    public static BookListDTO listDTO(BookDTO dto) {
        return new BookListDTO(dto.id(), dto.name(), dto.pages(), dto.chapters(),
                dto.isbn(), dto.publishedName(), dto.author().getName());
    }

}
