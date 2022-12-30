package com.itc.springboot.web;

import com.itc.springboot.dto.AuthorCreateRequestDTO;
import com.itc.springboot.dto.AuthorResponseDTO;
import com.itc.springboot.dto.AuthorUpdateRequestDTO;
import com.itc.springboot.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class AuthorResource {

    private final AuthorService authorService;

    //author detail
    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

    @PostMapping("/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid AuthorCreateRequestDTO dto) {
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long authorId,
                                             @RequestBody AuthorUpdateRequestDTO dto) {
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }
}
