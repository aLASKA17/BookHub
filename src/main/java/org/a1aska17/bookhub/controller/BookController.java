package org.a1aska17.bookhub.controller;

import org.a1aska17.bookhub.dto.BookResponse;
import org.a1aska17.bookhub.entity.Book;
import org.a1aska17.bookhub.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addbook")
    public Book addBook(@RequestBody BookResponse bookResponse) {
       return bookService.addBook(bookResponse);
    }

    @GetMapping("/infobook")
    public Book infoBook(@RequestBody BookResponse bookResponse) {
        return bookService.infoBookById(bookResponse);
    }

    @GetMapping("/listbooks")
    public List<Book> printListBooks() {
        return bookService.printListBooks();
    }
}
