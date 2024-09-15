package com.aditya.boilerplate.mapper;

import com.aditya.boilerplate.entity.Book;
import com.aditya.openapi.boilerplate.model.BookDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDtoConverter implements Converter<Book, BookDto> {

    @Override
    public BookDto convert(Book source) {
        BookDto bookDto = new BookDto();
        bookDto.setId(source.getId().toString());
        bookDto.setTitle(source.getTitle());
        bookDto.setAuthor(source.getAuthor());
        return bookDto;
    }
}
