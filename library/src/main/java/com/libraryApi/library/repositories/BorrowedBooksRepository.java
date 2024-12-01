package com.libraryApi.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libraryApi.library.entities.BorrowedBooks;

public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Long>{
    
}
