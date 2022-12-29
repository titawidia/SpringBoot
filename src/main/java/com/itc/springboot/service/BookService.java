package com.itc.springboot.service;

import com.itc.springboot.dto.BookCreateDTO;
import com.itc.springboot.dto.BookDetailDTO;
import com.itc.springboot.dto.BookUpdateRequestDTO;

import java.util.List;

public interface BookService {

    public BookDetailDTO findBookDetailById(Long bookId);

    public List<BookDetailDTO> findBookListDetail();

    public void createNewBook(BookCreateDTO dto);

    public void updateBook(Long bookId, BookUpdateRequestDTO dto);

    public void deleteBook(Long bookId);
}
