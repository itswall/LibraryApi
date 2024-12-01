package com.libraryApi.library.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.libraryApi.library.entities.User;
import com.libraryApi.library.exceptions.ex.ContentNotFound;
import com.libraryApi.library.exceptions.ex.UserAlreadyBorrowed;
import com.libraryApi.library.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
 
    private final UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUser(Long id){
        
        return userRepository.findById(id).orElseThrow(
            () -> new ContentNotFound("Id not Found")
        );
    }

    public User updateUser(Long id, User user){
        User userToUpdate = this.findUser(id);
 
        if (user.getEmail()!=null){
            userToUpdate.setEmail(user.getEmail());
        }
        if (user.getAddress() != null){
            userToUpdate.setAddress(user.getAddress());
        }
        if (user.getName() != null){
            userToUpdate.setName(user.getName());
        }
        if (user.getNumber()!= null) {
            userToUpdate.setNumber(user.getNumber());
        }

        return userRepository.save(userToUpdate);

    }
    
    public void deleteUser(Long id){
        var user = this.findUser(id);
        userRepository.delete(user);
    
            try {
            userRepository.delete(user);
        }
        catch (DataIntegrityViolationException e){

            throw new UserAlreadyBorrowed("User cannot be deleted with borrowed books!");
        }

    }
}
