package com.libraryApi.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryApi.library.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
