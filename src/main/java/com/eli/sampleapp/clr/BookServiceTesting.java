package com.eli.sampleapp.clr;

import com.eli.sampleapp.beans.Book;
import com.eli.sampleapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class BookServiceTesting implements CommandLineRunner {
    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {

        Book b1 = new Book();
        b1.setName("aaa");
        b1.setYear(2012);

        Book b2 = new Book();
        b2.setName("aaa");
        b2.setYear(2014);

        bookService.addBook(b1);
        try {
            bookService.addBook(b2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(bookService.getAllBooks());
    }

}
