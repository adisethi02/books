package com.aditya.boilerplate.mapper;

import com.aditya.boilerplate.entity.Book;
import com.aditya.boilerplate.entity.BookDetails;
import com.aditya.boilerplate.entity.Category;
import com.aditya.openapi.boilerplate.model.BookDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookDtoToBookConverter implements Converter<BookDto, Book> {
    @Override
    public Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());

        BookDetails bookDetails = new BookDetails();
        bookDetails.setIsbn(bookDto.getIsbn());
        bookDetails.setPages(bookDto.getPages());
        bookDetails.setCurrency(bookDto.getCurrency());
        bookDetails.setPrice(bookDto.getPrice());
        bookDetails.setLanguage(bookDto.getLanguage());
        book.setDetails(bookDetails);

        Category category = new Category();
        category.setName(bookDto.getCategory());
        book.setCategory(category);
        return book;
    }
}
