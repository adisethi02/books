package com.aditya.boilerplate.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "book_details", schema = "public")
public class BookDetails {
    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "language")
    private String language;

    @Column(name = "pages")
    private int pages;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    // Back reference to Book
    @OneToOne(mappedBy = "details")
    private Book book;
}

