package com.aditya.boilerplate.service;

import com.aditya.openapi.boilerplate.model.BookDto;
import com.aditya.openapi.boilerplate.model.BuyerDto;

import java.util.List;

public interface BookService {
    BookDto addBook(BookDto book);

    BookDto getBookById(String bookId);

    List<BookDto> getAllBooks();

    BookDto updateBook(String bookId, BookDto book);

    BookDto deleteBook(String bookId);

    void buyBook(String bookId, BuyerDto buyer);

    List<BuyerDto> getBuyers(String bookId);
}
