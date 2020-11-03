package com.eli.sampleapp.web;

import com.eli.sampleapp.beans.Author;
import com.eli.sampleapp.beans.Book;
import com.eli.sampleapp.exception.InvalidOperationException;
import com.eli.sampleapp.service.AuthorService;
import com.eli.sampleapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lib")
public class LibraryController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @PostMapping("add-book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            this.bookService.addBook(book);
            return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
        } catch (InvalidOperationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update-book")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        try {
            this.bookService.updateBook(book);
            return new ResponseEntity<>("updated successfully", HttpStatus.NO_CONTENT);
        } catch (InvalidOperationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete-author")
    public ResponseEntity<?> deleteAuthor(@RequestBody Author author) {
        this.authorService.deleteAuthor(author);
        return new ResponseEntity<>("deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping("get-authors")
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(this.authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("get-books/{year}")
    public ResponseEntity<?> getAllBooksByYear(@PathVariable int year) {
        return new ResponseEntity<>(this.bookService.getAllBooksByYear(year), HttpStatus.OK);
    }

}
