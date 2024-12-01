package com.libraryApi.library.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.libraryApi.library.entities.Books;
import com.libraryApi.library.exceptions.ex.ContentNotFound;
import com.libraryApi.library.repositories.BooksRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;

    public Books addNewBook(Books books){
        return booksRepository.save(books);
    }

    public List<Books> findAllBooks(){
        return booksRepository.findAll();
    }

    public Books findBook(Long id){

        return booksRepository.findById(id).orElseThrow(
            () -> new ContentNotFound("Id not found")
        );
    }
    
    public Books updateBook(Long id, Books books){
        Books bookToUpdate = this.findBook(id);
 
        if (books.getPublishYear()!= null){
            bookToUpdate.setPublishYear(books.getPublishYear());
        }
        if (books.getAuthor() != null){
            bookToUpdate.setAuthor(books.getAuthor());
        }
        if (books.getGenre() != null){
            bookToUpdate.setGenre(books.getGenre());
        }
        if (books.getTitle()!= null) {
            bookToUpdate.setTitle(books.getTitle());
        }
        return booksRepository.save(bookToUpdate);
    }

    public void deleteBook(Long id){
        var book = this.findBook(id);
        booksRepository.delete(book);
    }

    public List<Books> mostBorroweBooks(){
        var list = this.findAllBooks();

        return list.stream()
                .sorted(Comparator.comparing(Books::getBorrowedTimes).reversed())
                .collect(Collectors.toList());

    }

}
