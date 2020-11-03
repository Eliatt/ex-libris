package com.eli.sampleapp.clr;

import com.eli.sampleapp.beans.Author;
import com.eli.sampleapp.beans.Book;
import com.eli.sampleapp.repository.AuthorRepository;
import com.eli.sampleapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//@Component
public class Testing implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        Book b1 = new Book();
        b1.setName("aaa");
        b1.setYear(2012);

        //bookRepository.save(b1);
        Author a1 = new Author();
        a1.setName("Moshe");
        a1.getBooks().add(b1);

        authorRepository.save(a1);

        System.out.println(authorRepository.findAll());


        a1 = authorRepository.getOne(1);
        a1.getBooks().remove(0);
        authorRepository.saveAndFlush(a1);
//
//		authorRepository.deleteById(1);
//		System.out.println(authorRepository.findAll());


        //System.out.println(bookRepository.findAll());

    }

}