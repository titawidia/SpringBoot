package com.itc.springboot.repository;

import com.itc.springboot.domain.Book;

import java.util.List;

public interface BookRepository {

    public Book findBookById(Long id);

    public List<Book> findAll();

    public void save(Book book);

    public void update(Book book);

    public void delete(Long bookId);
}
