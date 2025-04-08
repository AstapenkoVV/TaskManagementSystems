package com.example.tms.repository;

import com.example.tms.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class AuthorRepository {

    private static Long sequence = 1L;
    private final List<Author> authors = new ArrayList<>();

    public Optional<Author> findById(Long id) {
        return authors.stream()
                .filter(author -> Objects.equals(author.getAuthorId(), id))
                .findFirst();
    }

    public List<Author> getAll() {
        return List.copyOf(authors);
    }

    public Author create(Author author) {
        author.setAuthorId(sequence++);
        authors.add(author);
        return author;
    }

    public void delete(Long id) {
        authors.stream()
                .filter(author -> Objects.equals(author.getAuthorId(), id))
                .findFirst()
                .ifPresent(authors::remove);
    }
}
