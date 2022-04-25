package com.example.laboratoriska_2.service;

import com.example.laboratoriska_2.model.Author;
import com.example.laboratoriska_2.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> save(String name, String surname, Long countryId);
    List<Author> findAllAuthors();
    void deleteById(Long id);
}
