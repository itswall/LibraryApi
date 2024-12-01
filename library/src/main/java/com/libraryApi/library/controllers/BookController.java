package com.libraryApi.library.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryApi.library.entities.Books;
import com.libraryApi.library.services.BooksService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    
    private final BooksService booksService;

    @PostMapping("/create")
    public ResponseEntity<Books> createNewBook(@RequestBody Books booksDto){
    return ResponseEntity.status(201).body(booksService.addNewBook(booksDto));

    }

    @GetMapping
    public ResponseEntity<List<Books>> findAllBooks(){
        return ResponseEntity.ok(booksService.findAllBooks());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Books> finBook(@PathVariable Long id){
        return ResponseEntity.ok(booksService.findBook(id));
    }

    
    @PatchMapping("/update/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books booksDto){
       return ResponseEntity.ok(booksService.updateBook(id, booksDto));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        booksService.deleteBook(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/mostBorrowed")
    public ResponseEntity<List<Books>> findMostBorrowedBooks(){
        return ResponseEntity.ok(booksService.mostBorroweBooks());
    }

}
