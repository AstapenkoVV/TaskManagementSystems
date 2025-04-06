package com.example.tms.cotroller;

import com.example.tms.model.Author;
import com.example.tms.service.AuthorService;
import com.example.tms.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        Optional<Author> author = authorService.findById(id);
        if (author.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(author.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
