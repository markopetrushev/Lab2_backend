package com.example.laboratoriska_2.model;

import com.example.laboratoriska_2.model.enums.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book() {

    }
}
