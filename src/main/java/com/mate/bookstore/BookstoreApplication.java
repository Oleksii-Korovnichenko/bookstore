package com.mate.bookstore;

import com.mate.bookstore.model.Book;
import com.mate.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
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
