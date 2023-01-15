package com.example.SpringFrameworkPractice.bootstrap;

import com.example.SpringFrameworkPractice.domain.Author;
import com.example.SpringFrameworkPractice.domain.Book;
import com.example.SpringFrameworkPractice.domain.Publisher;
import com.example.SpringFrameworkPractice.repositories.AuthorRepository;
import com.example.SpringFrameworkPractice.repositories.BookRepository;
import com.example.SpringFrameworkPractice.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        Publisher aiks = new Publisher("Aiks","Palm st","Accra","Greater Accra","12345");
        publisherRepository.save(aiks);
        ddd.setPublisher(aiks);
        aiks.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(aiks);

        Author rod = new Author("Rod", "Johnson");
        Book noEJb = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJb);
        noEJb.getAuthors().add(rod);
        noEJb.setPublisher(aiks);
        aiks.getBooks().add(noEJb);

        authorRepository.save(rod);
        bookRepository.save(noEJb);


        publisherRepository.save(aiks);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers " + publisherRepository.count());
        System.out.println("Number of publisher books " + aiks.getBooks().size());
    }
}
