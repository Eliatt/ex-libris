package com.eli.sampleapp.service;

import com.eli.sampleapp.beans.Author;
import com.eli.sampleapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public void addAuthor(Author author) {

        authorRepository.save(author);
    }


    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }



}
