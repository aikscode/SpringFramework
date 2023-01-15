package com.example.SpringFrameworkPractice.repositories;

import com.example.SpringFrameworkPractice.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
