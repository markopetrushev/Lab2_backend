package com.example.laboratoriska_2.service;

import com.example.laboratoriska_2.model.Country;

import java.util.Optional;

public interface CountryService {

    Optional<Country> save(String name, String continent);
    void deleteById(Long id);
}
