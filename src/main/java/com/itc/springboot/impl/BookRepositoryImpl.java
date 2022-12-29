package com.itc.springboot.impl;

import com.itc.springboot.domain.Book;
import com.itc.springboot.repository.BookRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book> bookMap;

    @Override
    public Book findBookById(Long id) {
        Book book = bookMap.get(id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<Book>(bookMap.values());
        return bookList;
    }

    @Override
    public void save(Book book) {
        //size = 2, -> 1, 2
        int size = bookMap.size();
        book.setId((long) size+1);
        bookMap.put(book.getId(), book);
    }

    @Override
    public void update(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public void delete(Long bookId) {
        bookMap.remove(bookId);
    }
}
