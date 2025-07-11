package com.mate.bookstore;

import com.mate.bookstore.model.Book;
import com.mate.bookstore.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner demo(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("Some title");
            book.setAuthor("Any author");
            book.setIsbn("9780132350884");
            book.setPrice(BigDecimal.valueOf(30.00));
            book.setDescription("Some description");
            book.setCoverImage("img path");

            bookService.save(book);
            bookService.findAll().forEach(System.out::println);
        };
    }
}
