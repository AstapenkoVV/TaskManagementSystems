package com.example.tms.service;

import com.example.tms.model.Author;
import com.example.tms.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> findAll() {
        return authorRepository.getAll();
    }

    public Author create(Author author) {
        return authorRepository.create(author);
    }

    public void delete(Long id) {
        authorRepository.delete(id);
    }
}
