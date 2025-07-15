package com.mate.bookstore;

import com.mate.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceIntegrationTest {
	@Autowired
	private BookService bookService;

}
