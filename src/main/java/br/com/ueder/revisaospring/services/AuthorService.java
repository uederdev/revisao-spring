package br.com.ueder.revisaospring.services;

import br.com.ueder.revisaospring.dtos.AuthorDTO;
import br.com.ueder.revisaospring.exceptions.ObjectNotFoundException;
import br.com.ueder.revisaospring.models.Author;
import br.com.ueder.revisaospring.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<AuthorDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(Author::toDTO)
                .toList();
    }

    public AuthorDTO findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(String.valueOf(id)))
                .toDTO();
    }

    @Transactional
    public Author save(Author model) {
        return repository.save(model);
    }

    @Transactional
    public Author update(Long id, AuthorDTO dto){
        Author model = findById(id).toModel();
        model.setAge(dto.age());
        model.setName(dto.name());
        return repository.saveAndFlush(model);
    }
}
