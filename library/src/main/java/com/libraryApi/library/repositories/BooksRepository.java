package com.libraryApi.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libraryApi.library.entities.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{

}
