package com.itc.springboot.impl;

import com.itc.springboot.domain.Author;
import com.itc.springboot.dto.AuthorCreateRequestDTO;
import com.itc.springboot.dto.AuthorResponseDTO;
import com.itc.springboot.dto.AuthorUpdateRequestDTO;
import com.itc.springboot.exception.BadRequestException;
import com.itc.springboot.repository.AuthorRepository;
import com.itc.springboot.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(Long id) {

        //1. fetch data from database
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("invalid.authorId"));
        //2. author -> authorResponseDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }

    @Override
    public void createNewAuthor(AuthorCreateRequestDTO dto) {

        Author author = new Author();
        author.setName(dto.getAuthorName());
        author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new BadRequestException("invalid.authorId"));
        author.setName(dto.getAuthorName() == null?author.getName(): dto.getAuthorName());
        author.setBirthDate(dto.getBirthDate() == null?author.getBirthDate():LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        //1. select data
        //2. delete
        //or
        //1. delete (hardDelete)
        authorRepository.deleteById(authorId);

        //softDelete
        //1. select data deleted=false
//        Author author= authorRepository.findByIdAndDeletedFalse(authorId)
//                .orElseThrow(() -> new BadRequestException("invalid.authorId"));
//
//        //2. update deleted=true
//        author.setDeleted(Boolean.TRUE);
//        authorRepository.save(author);

    }
}
