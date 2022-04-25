package com.example.laboratoriska_2.model.dto;

import com.example.laboratoriska_2.model.Author;
import com.example.laboratoriska_2.model.enums.Category;
import lombok.Data;

@Data
public class BookDto {

    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
