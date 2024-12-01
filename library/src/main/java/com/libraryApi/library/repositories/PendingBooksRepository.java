package com.libraryApi.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryApi.library.entities.PendingBooks;

public interface PendingBooksRepository extends JpaRepository<PendingBooks, Long>{
    
}
