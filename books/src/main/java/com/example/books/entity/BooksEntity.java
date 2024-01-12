package com.example.books.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name = "books")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "author")

    private String author;
    @Column(name = "title")

    private String title;
    @Column(name = "downloadCount")

    private int downloadCount;
    private String description;

}
