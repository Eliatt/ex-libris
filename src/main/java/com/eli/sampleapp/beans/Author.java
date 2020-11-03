package com.eli.sampleapp.beans;

import com.eli.sampleapp.exception.InvalidOperationException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) throws InvalidOperationException {
        for (Book b : books) {
            if (book.getName().equals(b.getName())) {
                throw new InvalidOperationException("book name already exist");
            }
        }
        books.add(book);
    }
}
