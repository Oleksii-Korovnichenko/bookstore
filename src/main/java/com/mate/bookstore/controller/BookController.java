package com.mate.bookstore.controller;

import com.mate.bookstore.dto.BookDto;
import com.mate.bookstore.dto.CreateBookRequestDto;
import com.mate.bookstore.mapper.BookMapper;
import com.mate.bookstore.model.Book;
import com.mate.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book book = bookService.getById(id);
        return bookMapper.toDto(book);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody CreateBookRequestDto bookRequestDtoDto) {
        Book book = bookMapper.toModel(bookRequestDtoDto);
        Book savedBook = bookService.createBook(book);
        return bookMapper.toDto(savedBook);
    }
}
