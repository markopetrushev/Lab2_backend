package com.example.laboratoriska_2.repository;

import com.example.laboratoriska_2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    void deleteByName(String name);
}
