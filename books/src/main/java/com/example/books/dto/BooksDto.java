package com.example.books.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class BooksDto {

    private int id;

    private String author;

    private String title;

    private String description;

    private int downloadCount;
}
