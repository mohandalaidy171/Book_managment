package com.example.books.controller;

import com.example.books.dto.BooksDto;
import com.example.books.entity.BooksEntity;
import com.example.books.servive.BooksService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/")
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
@GetMapping("all")
    public ResponseEntity<List<BooksEntity>> getAll(){

        return ResponseEntity.ok(booksService.getAll());
}

@PostMapping("add")
    public ResponseEntity<BooksEntity> addBook(@RequestBody BooksDto booksDto){

        BooksEntity books=booksService.addBook(booksDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(books);
}

@DeleteMapping("delet")
    public ResponseEntity<String> deletById(@RequestParam int id){

        return ResponseEntity.ok(booksService.deletById(id));
}

@PutMapping("update")
    public ResponseEntity<String> updateByTitle(@RequestParam String title,@RequestParam int id){
        return ResponseEntity.ok(booksService.updateByTitle(title,id));

}

@GetMapping("byid")
    public ResponseEntity<BooksEntity> getById(@RequestParam int id){

        return ResponseEntity.ok(booksService.getById(id));
}
}
