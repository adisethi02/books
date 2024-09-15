package com.aditya.boilerplate.controller;

import com.aditya.boilerplate.service.BookService;
import com.aditya.openapi.boilerplate.api.BooksApi;
import com.aditya.openapi.boilerplate.model.BookDto;
import com.aditya.openapi.boilerplate.model.BuyerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BooksApiDelegateImpl implements BooksApi {

    @Autowired
    private BookService bookService;

    @Override
    public ResponseEntity<BookDto> addBook(BookDto book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @Override
    public ResponseEntity<BookDto> deleteBook(String id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BookDto> getBookById(String id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Override
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Override
    public ResponseEntity<BookDto> updateBook(String id, BookDto book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @Override
    public ResponseEntity<BookDto> buyBook(String id, BuyerDto buyer) {
        bookService.buyBook(id, buyer);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<BuyerDto>> getBuyers(String id) {
        return ResponseEntity.ok(bookService.getBuyers(id));
    }
}
