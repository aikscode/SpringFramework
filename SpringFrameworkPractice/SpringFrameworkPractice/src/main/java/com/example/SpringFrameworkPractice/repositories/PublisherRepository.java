package com.example.SpringFrameworkPractice.repositories;

import com.example.SpringFrameworkPractice.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
