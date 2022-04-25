package com.example.laboratoriska_2.repository;

import com.example.laboratoriska_2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteByName(String name);
}
