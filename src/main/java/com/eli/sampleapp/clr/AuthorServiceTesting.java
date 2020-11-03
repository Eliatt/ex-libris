package com.eli.sampleapp.clr;

import com.eli.sampleapp.beans.Author;
import com.eli.sampleapp.beans.Book;
import com.eli.sampleapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class AuthorServiceTesting implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {

        Book b1 = new Book();
        b1.setName("aaa");
        b1.setYear(2012);

        Book b2 = new Book();
        b2.setName("aaa");
        b2.setYear(2014);

        Author a1 = new Author();
        a1.setName("Moshe");
        try {
            a1.addBook(b1);
            a1.addBook(b2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // a1.getBooks().add(b1);
        // a1.getBooks().add(b2);
        authorService.addAuthor(a1);

        System.out.println(authorService.getAllAuthors());

    }

}
