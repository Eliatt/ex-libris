package com.eli.sampleapp.repository;

import com.eli.sampleapp.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
