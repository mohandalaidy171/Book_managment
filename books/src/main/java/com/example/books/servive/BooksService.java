package com.example.books.servive;

import com.example.books.dto.BooksDto;
import com.example.books.entity.BooksEntity;
import com.example.books.repository.BooksRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List< BooksEntity> getAll() {
        return  booksRepository.findAll();
    }

    public BooksEntity addBook(BooksDto booksDto) {

        BooksEntity books=new BooksEntity();

        books.setAuthor(booksDto.getAuthor());
        books.setTitle(booksDto.getTitle());
        books.setDownloadCount(booksDto.getDownloadCount());
        return booksRepository.save(books);
    }

    public String deletById(int id) {
        int test =booksRepository.deleteById(id);
        if(test ==1){

            return "Delete Success";
        }else { return "Delete Not Success";}
    }
@Transactional
    public String updateByTitle(String title, int id) {

        int test=booksRepository.updateByTittle(title,id);
        if(test ==1){

            return "Delete Success";
        }else { return "Delete Not Success";}
    }

    public BooksEntity getById(int id) {
        return booksRepository.findById(id).orElseThrow(()->new RuntimeException("ID NOT FOUND"));
    }
}
