package com.aditya.boilerplate.mapper;

import com.aditya.boilerplate.entity.Book;
import com.aditya.openapi.boilerplate.model.BookDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookDtoToBookConverter implements Converter<BookDto, Book> {
    @Override
    public Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setId(UUID.fromString(bookDto.getId()));
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        return book;
    }
}
