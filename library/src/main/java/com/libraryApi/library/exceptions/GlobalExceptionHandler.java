package com.libraryApi.library.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.libraryApi.library.exceptions.ex.ContentNotFound;
import com.libraryApi.library.exceptions.ex.MaxBorrows;
import com.libraryApi.library.exceptions.ex.PendingTimeLimit;
import com.libraryApi.library.exceptions.ex.UserAlreadyBorrowed;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> invalidFields(MethodArgumentNotValidException ex, HttpServletRequest request, BindingResult result) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Fields", result));
    }
    @ExceptionHandler(ContentNotFound.class)
    public ResponseEntity<MessageError> handleContentNotFound(ContentNotFound ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }
    @ExceptionHandler(PendingTimeLimit.class)
    public ResponseEntity<MessageError> handlePendingTimeLimit(PendingTimeLimit ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }

    @ExceptionHandler(MaxBorrows.class)
    public ResponseEntity<MessageError> handleMaxBorrows(MaxBorrows ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }
    @ExceptionHandler(UserAlreadyBorrowed.class)
    public ResponseEntity<MessageError> handleUserAlreadyBorrowed(UserAlreadyBorrowed ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<MessageError> cpfOrEmailAlreadyExist(DataIntegrityViolationException ex, HttpServletRequest request) {
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, "Email already in use."));
    }


}
