package com.eli.sampleapp.service;

import com.eli.sampleapp.beans.Book;
import com.eli.sampleapp.exception.InvalidOperationException;
import com.eli.sampleapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void  addBook(Book book) throws InvalidOperationException {
        List<Book> books = getAllBooks();
        for (Book b : books) {
            if(book.getName().equals(b.getName())) {
                throw new InvalidOperationException("Book name already exist");
            }
        }

        bookRepository.save(book);
    }

    public void updateBook(Book book) throws InvalidOperationException {
        List<Book> books = getAllBooks();
        for (Book b : books) {
            if(book.getId()==b.getId()) {
                bookRepository.saveAndFlush(book);
            }
        }
        throw new InvalidOperationException("Book not exist");
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public List<Book>getAllBooksByYear(int year){
        return bookRepository.findByYear(year);
    }

}

