package com.example.laboratoriska_2.web.rest;

import com.example.laboratoriska_2.model.Author;
import com.example.laboratoriska_2.model.Book;
import com.example.laboratoriska_2.model.dto.BookDto;
import com.example.laboratoriska_2.model.enums.Category;
import com.example.laboratoriska_2.service.AuthorService;
import com.example.laboratoriska_2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    //Read
    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    //Create
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto.getName(), bookDto.getCategory(), bookDto.getAuthorId(), bookDto.getAvailableCopies())
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //Update
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto.getName(), bookDto.getCategory(), bookDto.getAuthorId(), bookDto.getAvailableCopies())
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("rent/{id}")
    public ResponseEntity<Book> take(@PathVariable Long id){

        return this.bookService.RentABook(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //ReadCategories
    @GetMapping("/categories")
    public List<String> findAllCategories() {
        List<String> category = new ArrayList<String>();
        Arrays.stream(Category.values()).forEach(i->category.add(i.name()));
        return category;
    }

    //ReadAuthors
    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        System.out.println(authorService.findAllAuthors());
        return authorService.findAllAuthors();
    }
}
