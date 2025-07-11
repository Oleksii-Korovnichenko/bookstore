package com.mate.bookstore;

import com.mate.bookstore.model.Book;
import com.mate.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class BookServiceIntegrationTest {
	@Autowired
	private BookService bookService;

	@Test
	public void testSaveAndFindAll() {
		Book book = new Book();
		book.setTitle("Test Book");
		book.setAuthor("Test Author");
		book.setIsbn("1234567890");
		book.setPrice(BigDecimal.TEN);
		book.setDescription("Test description");

		bookService.save(book);
		List<Book> allBooks = bookService.findAll();

		assertFalse(allBooks.isEmpty());
		assertEquals("Test Book", allBooks.get(0).getTitle());
	}
}
