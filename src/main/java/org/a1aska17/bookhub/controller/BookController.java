package org.a1aska17.bookhub.controller;

import org.a1aska17.bookhub.dto.BookResponse;
import org.a1aska17.bookhub.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {
    private BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addbook")
    public void addBook(@RequestBody BookResponse bookResponse) {
        bookService.addBook(bookResponse);
    }
}
