package com.libraryApi.library.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.libraryApi.library.entities.PendingBooks;
import com.libraryApi.library.exceptions.ex.ContentNotFound;
import com.libraryApi.library.exceptions.ex.MaxBorrows;
import com.libraryApi.library.repositories.PendingBooksRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PendingBooksService {
    
    private final UserService userService;
    private final BooksService booksService;
    private final PendingBooksRepository pendingBooksRepository;

    public List<PendingBooks> findAllPendingBooks(){
        return pendingBooksRepository.findAll();
    }

    public PendingBooks newPendingBook(Long userId, Long bookId){

        var user = userService.findUser(userId);
        var book = booksService.findBook(bookId);

        for (PendingBooks e: this.findAllPendingBooks()){
            if (e.getUser()==user){
                 throw new MaxBorrows("Limite maximo de emprestimos pendentes foi atingido");
             }
        }

        PendingBooks pendingBooks = new PendingBooks();
        pendingBooks.setUser(user);
        pendingBooks.setBooks(book);

        return pendingBooksRepository.save(pendingBooks);
    }

        public void returnPendingBook(Long user_id, Long book_id){

        for (PendingBooks l : this.findAllPendingBooks()){
            if (Objects.equals(l.getUser().getId(), user_id) && Objects.equals(l.getBooks().getId(), book_id)){
                pendingBooksRepository.delete(l);
                return;
            }

        }

         throw new ContentNotFound(
                 "No users found."
        );
    }
}
