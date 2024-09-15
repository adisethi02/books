package com.aditya.boilerplate.service;

import com.aditya.boilerplate.entity.Book;
import com.aditya.boilerplate.entity.Buyer;
import com.aditya.boilerplate.mapper.BookDtoToBookConverter;
import com.aditya.boilerplate.mapper.BookToBookDtoConverter;
import com.aditya.boilerplate.repository.BookRepository;
import com.aditya.openapi.boilerplate.model.BookDto;
import com.aditya.openapi.boilerplate.model.BuyerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookDtoToBookConverter bookDtoToBookConverter;

    @Autowired
    BookToBookDtoConverter bookToBookDtoConverter;

    @Override
    public BookDto addBook(BookDto book) {
        log.info("Adding book: {}", book);
        Book savedBook = bookRepository.save(bookDtoToBookConverter.convert(book));
        return bookToBookDtoConverter.convert(savedBook);
    }

    @Override
    public BookDto getBookById(String bookId) {
        log.info("Getting book by id: {}", bookId);
        Optional<Book> book = bookRepository.findById(UUID.fromString(bookId));
        return book.map(bookToBookDtoConverter::convert).orElse(null);
    }

    @Override
    public List<BookDto> getAllBooks() {
        log.info("Getting all books");
        return bookRepository.findAll().stream().map(bookToBookDtoConverter::convert).toList();
    }

    @Override
    public BookDto updateBook(String bookId, BookDto book) {
        log.info("Updating book with id: {}", bookId);
        Book existingBook = bookRepository.findById(UUID.fromString(bookId)).orElse(null);
        Book bookToUpdate = bookDtoToBookConverter.convert(book);
        bookToUpdate.setId(UUID.fromString(bookId));
        bookToUpdate.getDetails().setId(existingBook.getDetails().getId());
        bookToUpdate.getCategory().setId(existingBook.getCategory().getId());
        Book updatedBook = bookRepository.save(bookToUpdate);
        return bookToBookDtoConverter.convert(updatedBook);
    }

    @Override
    public BookDto deleteBook(String bookId) {
        log.info("Deleting book with id: {}", bookId);
        Optional<Book> book = bookRepository.findById(UUID.fromString(bookId));
        book.ifPresent(bookRepository::delete);
        return book.map(bookToBookDtoConverter::convert).orElse(null);
    }

    @Override
    public void buyBook(String bookId, BuyerDto buyer) {
        log.info("Buying book with id: {}", bookId);
        Optional<Book> book = bookRepository.findById(UUID.fromString(bookId));
        Buyer buyerEntity = new Buyer();
        buyerEntity.setName(buyer.getName());
        buyerEntity.setEmail(buyer.getEmail());
        book.ifPresent(b -> {
            b.getBuyers().add(buyerEntity);
            bookRepository.save(b);
        });
    }

    @Override
    public List<BuyerDto> getBuyers(String bookId) {
        log.info("Getting buyers for book with id: {}", bookId);
        Optional<Book> book = bookRepository.findById(UUID.fromString(bookId));
        System.out.println(book.isPresent());
        return book.map(b -> b.getBuyers().stream().map(buyer -> {
            BuyerDto buyerDto = new BuyerDto();
            buyerDto.setId(buyer.getId().toString());
            buyerDto.setName(buyer.getName());
            buyerDto.setEmail(buyer.getEmail());
            return buyerDto;
        }).toList()).orElse(null);
    }
}
