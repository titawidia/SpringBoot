package com.itc.springboot.service;

import com.itc.springboot.dto.AuthorResponseDTO;

public interface AuthorService {

    public AuthorResponseDTO findAuthorById(Long id);
}
