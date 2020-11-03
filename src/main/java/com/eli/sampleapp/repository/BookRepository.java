package com.eli.sampleapp.repository;

import com.eli.sampleapp.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book>findByYear(int year);
}
