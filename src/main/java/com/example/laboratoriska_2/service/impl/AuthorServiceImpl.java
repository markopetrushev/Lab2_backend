package com.example.laboratoriska_2.service.impl;

import com.example.laboratoriska_2.model.Author;
import com.example.laboratoriska_2.model.Country;
import com.example.laboratoriska_2.repository.AuthorRepository;
import com.example.laboratoriska_2.repository.CountryRepository;
import com.example.laboratoriska_2.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public Optional<Author> save(String name, String surname, Long countryId) {

        this.authorRepository.deleteByName(name);
        System.out.println(name + " " + surname + " " + countryId);
        Country country = this.countryRepository.findById(countryId).get();
        Author author = new Author(name, surname, country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
