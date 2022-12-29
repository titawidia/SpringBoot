package com.itc.springboot.web;

import com.itc.springboot.dto.BookCreateDTO;
import com.itc.springboot.dto.BookDetailDTO;
import com.itc.springboot.dto.BookUpdateRequestDTO;
import com.itc.springboot.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    //nama yang salah -> /get-book/{bookId}
    @GetMapping("/book/{bookId}")
    public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
        StopWatch stopWatch = new StopWatch();
        log.info("start findBookDetail "+id);
        stopWatch.start();
        BookDetailDTO result = bookService.findBookDetailById(id);
        log.info("finish findBookDetail. execute time = {}",stopWatch.getTotalTimeMillis());
        return result;
    }

    //nama yang salah -> /save-book /create-book
    @PostMapping("/book")
    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateDTO dto) {
        bookService.createNewBook(dto);
        return ResponseEntity.created(URI.create("/book")).build();
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookDetailDTO>> findBookList() {
        return ResponseEntity.ok().body(bookService.findBookListDetail());
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId,
                                           @RequestBody BookUpdateRequestDTO dto) {
        bookService.updateBook(bookId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
