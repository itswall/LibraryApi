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

import com.libraryApi.library.entities.PendingBooks;
import com.libraryApi.library.entities.dto.PendingBooksDto;
import com.libraryApi.library.services.PendingBooksService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/PendingBooks")
public class PendingBooksController {

    private final PendingBooksService pendingBooksService;

    @PostMapping("/NewPending")
    public ResponseEntity<PendingBooks> newPending(@RequestBody PendingBooksDto pendingBooksDto){

        return ResponseEntity.status(201).body(pendingBooksService.newPendingBook(pendingBooksDto.userId(),
                pendingBooksDto.bookId()));
    }
    
    @GetMapping
    public ResponseEntity<List<PendingBooks>> findAllPendingBooks(){
        return ResponseEntity.ok(pendingBooksService.findAllPendingBooks());
    }    

    @DeleteMapping("/returnPending/{userId}/{bookId}")
    public ResponseEntity<Void> returnBook(@PathVariable Long userId, @PathVariable  Long bookId ){
        pendingBooksService.returnPendingBook(userId, bookId);
        return ResponseEntity.ok().build();
    }
}
