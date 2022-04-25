package com.example.laboratoriska_2.service;

import com.example.laboratoriska_2.model.Author;
import com.example.laboratoriska_2.model.Book;
import com.example.laboratoriska_2.model.enums.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> RentABook(Long id);

    void deleteById(Long id);

    Optional<Book> findById(Long id);
}
