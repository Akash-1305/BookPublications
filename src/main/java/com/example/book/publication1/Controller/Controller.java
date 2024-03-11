package com.example.book.publication1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.publication1.Entity.Book;
import com.example.book.publication1.Repository.BookRepo;

@RestController
@RequestMapping("/books")
public class Controller {

    private final BookRepo bookRepo; 

    @Autowired
    public Controller(BookRepo bookRepo) { 
        this.bookRepo = bookRepo;
    }

    @PostMapping("/addbook")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookRepo.save(book); 
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/getbook")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepo.findAll(); 
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
