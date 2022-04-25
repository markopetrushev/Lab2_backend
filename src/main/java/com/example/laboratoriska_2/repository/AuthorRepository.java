package com.example.laboratoriska_2.repository;

import com.example.laboratoriska_2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    void deleteByName(String name);

}
