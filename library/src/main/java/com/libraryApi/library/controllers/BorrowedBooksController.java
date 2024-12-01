package com.libraryApi.library.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryApi.library.entities.BorrowedBooks;
import com.libraryApi.library.entities.dto.BorrowedBooksDto;
import com.libraryApi.library.services.BorrowedBooksService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/borrows")
@RequiredArgsConstructor
public class BorrowedBooksController {

    private final BorrowedBooksService borrowedBooksService;

    @PostMapping("/newBorrow")
    public ResponseEntity<BorrowedBooks> borrowNewBook(@RequestBody BorrowedBooksDto borrowedBooksDto) {
        return ResponseEntity.status(201)
                .body(borrowedBooksService.borrowNewBook(
                    borrowedBooksDto.userId(),
                    borrowedBooksDto.bookId(),
                    borrowedBooksDto.returnDate()));
    }

    @GetMapping
    public ResponseEntity<List<BorrowedBooks>> findAllBorrowedBooks(){
        return ResponseEntity.ok(borrowedBooksService.findAllBorrowedBooks());
    }
    
    @DeleteMapping("/return/{userId}/{bookId}")
    public ResponseEntity<Void> returnBook(@PathVariable Long userId, @PathVariable  Long bookId ){
        borrowedBooksService.returnBook(userId, bookId);
        return ResponseEntity.ok().build();
    }
}
