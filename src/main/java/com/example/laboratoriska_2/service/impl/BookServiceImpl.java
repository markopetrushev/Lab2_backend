package com.example.laboratoriska_2.service.impl;

import com.example.laboratoriska_2.model.Author;
import com.example.laboratoriska_2.model.Book;
import com.example.laboratoriska_2.model.enums.Category;
import com.example.laboratoriska_2.repository.AuthorRepository;
import com.example.laboratoriska_2.repository.BookRepository;
import com.example.laboratoriska_2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).get();
        Book book = new Book(name, category, author, availableCopies);
        this.bookRepository.deleteByName(name);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> RentABook(Long id) {
        Book book = this.bookRepository.findById(id).get();
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).get();
        Author author = this.authorRepository.findById(authorId).get();

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }
}
