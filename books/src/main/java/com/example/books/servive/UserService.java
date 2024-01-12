package com.example.books.servive;

import com.example.books.entity.BooksEntity;
import com.example.books.repository.BooksRepository;
import com.example.books.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, BooksRepository booksRepository) {
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
    }

    private final BooksRepository booksRepository;
    public String downloadBook(int id) {
        Optional<BooksEntity> optionalBook = booksRepository.findById(id);

        if (optionalBook.isPresent()) {

            BooksEntity book = optionalBook.get();
            book.setDownloadCount(book.getDownloadCount() + 1);


            booksRepository.save(book);
            return "success";
        } else {
           return "Book not found with id: " + id;
        }
    }
}
