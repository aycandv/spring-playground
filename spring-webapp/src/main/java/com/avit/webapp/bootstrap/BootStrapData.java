package com.avit.webapp.bootstrap;

import com.avit.webapp.domain.Author;
import com.avit.webapp.domain.Book;
import com.avit.webapp.domain.Publisher;
import com.avit.webapp.repositories.AuthorRepository;
import com.avit.webapp.repositories.BookRepository;
import com.avit.webapp.repositories.PublisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setName("Pearson");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author aycan = new Author("Aycan", "Vit");
        Book book = new Book("Domain Driven Design", "123123");
        aycan.getBooks().add(book);
        book.getAuthors().add(aycan);

        authorRepository.save(aycan);
        bookRepository.save(book);

        Author deniz = new Author("Deniz", "Tiv");
        Book book1 = new Book("Spring Tutorials", "111222");
        deniz.getBooks().add(book1);
        book1.getAuthors().add(deniz);

        authorRepository.save(deniz);
        bookRepository.save(book1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
