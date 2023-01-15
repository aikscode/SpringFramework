package com.example.SpringFrameworkPractice.repositories;

import com.example.SpringFrameworkPractice.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
