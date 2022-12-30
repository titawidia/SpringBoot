package com.itc.springboot.service;

import com.itc.springboot.domain.Author;
import com.itc.springboot.dto.AuthorCreateRequestDTO;
import com.itc.springboot.dto.AuthorResponseDTO;
import com.itc.springboot.dto.AuthorUpdateRequestDTO;

public interface AuthorService {

    public AuthorResponseDTO findAuthorById(Long id);

    public void createNewAuthor(AuthorCreateRequestDTO dto);

    public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto);
}
