package com.libraryApi.library.entities.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record BorrowedBooksDto(

    Long Id,
    Long userId,
    Long bookId,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate returnDate
) {
    
}
