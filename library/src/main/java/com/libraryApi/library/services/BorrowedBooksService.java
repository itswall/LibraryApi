package com.libraryApi.library.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.libraryApi.library.entities.BorrowedBooks;
import com.libraryApi.library.exceptions.ex.ContentNotFound;
import com.libraryApi.library.exceptions.ex.MaxBorrows;
import com.libraryApi.library.repositories.BorrowedBooksRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowedBooksService {
    
    private final BorrowedBooksRepository borrowedBooksRepository;
    private final BooksService booksService;
    private final UserService userService;

    public List<BorrowedBooks> findAllBorrowedBooks(){
        return borrowedBooksRepository.findAll();
    }

    
    public BorrowedBooks borrowNewBook(Long user_id, Long book_id, LocalDate returnDate){

        var user = userService.findUser(user_id);
        var book = booksService.findBook(book_id);
        var borrowPerUser = 0;

        for (BorrowedBooks l: findAllBorrowedBooks()){
            if (Objects.equals(l.getUser().getId(), user.getId())){
                borrowPerUser += 1;
            }
            if (borrowPerUser>=2){
                 throw new MaxBorrows("Users already borrow the max limit");
            }
        }

        BorrowedBooks borrowedBooks = new BorrowedBooks();
        borrowedBooks.setBooks(book);
        borrowedBooks.setUser(user);
        borrowedBooks.setReturnDate(returnDate);

        book.setBorrowedTimes(book.getBorrowedTimes()+1);
        return borrowedBooksRepository.save(borrowedBooks);

    }

    public void returnBook(Long user_id, Long book_id){

        for (BorrowedBooks l : this.findAllBorrowedBooks()){
            if (Objects.equals(l.getUser().getId(), user_id) && Objects.equals(l.getBooks().getId(), book_id)){
                borrowedBooksRepository.delete(l);
                return;
            }

        }

         throw new ContentNotFound(
                 "No users found."
        );
    }

}
