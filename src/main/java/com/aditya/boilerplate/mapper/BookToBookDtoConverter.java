package com.aditya.boilerplate.mapper;

import com.aditya.boilerplate.entity.Book;
import com.aditya.boilerplate.entity.BookDetails;
import com.aditya.boilerplate.entity.Category;
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

        BookDetails bookDetails = source.getDetails();
        if (bookDetails != null) {
            bookDto.setIsbn(bookDetails.getIsbn());
            bookDto.setPages(bookDetails.getPages());
            bookDto.setCurrency(bookDetails.getCurrency());
            bookDto.setPrice(bookDetails.getPrice());
            bookDto.setLanguage(bookDetails.getLanguage());
        }


        Category category = source.getCategory();
        if (category != null)
            bookDto.setCategory(category.getName());

        return bookDto;
    }
}
