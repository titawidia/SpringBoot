package com.itc.springboot.config;

import com.itc.springboot.domain.Author;
import com.itc.springboot.domain.Book;
import com.itc.springboot.impl.BookRepositoryImpl;
import com.itc.springboot.repository.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@ComponentScan
@Configuration
public class AppConfig {

//    @Bean
//    public Author author() {
//        return new Author(
//                1L,
//                "Fiersa Besari",
//                null,
//                false);
//    }
//
//    @Bean
//    public Book book(Author author) {
//        Book book = new Book();
//        book.setId(1L);
//        book.setTitle("Garis Waktu");
//        book.setDescription("Garis waktu merupakan salah satu buku karya Fiersa Besari");
//        book.setAuthor(author);
//        return book;
//    }
//
//    @Bean
//    public BookRepository bookRepository(Book book) {
//        Map<Long, Book> bookMap = new HashMap<Long, Book>();
//        bookMap.put(1L, book);
//
//        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
//        bookRepository.setBookMap(bookMap);
//
//        return bookRepository;
//    }


}
