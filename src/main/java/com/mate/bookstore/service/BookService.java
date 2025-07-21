package com.mate.bookstore.service;

import com.mate.bookstore.model.Book;
import java.util.List;

public interface BookService {
    Book createBook(Book book);

    List<Book> getAll();

    Book getById(Long id);
}
