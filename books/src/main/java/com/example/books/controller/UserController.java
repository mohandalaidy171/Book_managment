package com.example.books.controller;

import com.example.books.servive.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("byid")
    public ResponseEntity<String> downloadBook(@RequestParam int id){

       return ResponseEntity.ok( userService.downloadBook(id));
    }
}
