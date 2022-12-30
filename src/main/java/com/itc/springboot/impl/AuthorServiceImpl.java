package com.itc.springboot.impl;

import com.itc.springboot.dto.AuthorResponseDTO;
import com.itc.springboot.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public AuthorResponseDTO findAuthorById(Long id) {
        //1. fetch data from database
        //2. author -> authorResponseDTO
        return null;
    }
}
