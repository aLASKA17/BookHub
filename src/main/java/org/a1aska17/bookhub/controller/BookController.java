package org.a1aska17.bookhub.controller;

import lombok.Data;
import org.a1aska17.bookhub.dto.book.CreateBookRequest;
import org.a1aska17.bookhub.dto.book.UpdateBookRequest;
import org.a1aska17.bookhub.entity.Book;
import org.a1aska17.bookhub.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Data
public class BookController {
    private BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody CreateBookRequest createBookRequest) {
       return bookService.addBook(createBookRequest);
    }

    @GetMapping("/{idBook}")
    public Book findBook(@PathVariable Long bookId) {
        return bookService.findBookById(bookId);
    }

    @GetMapping
    public List<Book> findListBooks() {
        return bookService.findListBooks();
    }

    @PutMapping("/{idBook}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody UpdateBookRequest updateBookRequest) {
        return bookService.updateBookById(bookId, updateBookRequest);
    }

    @DeleteMapping("/{idBook}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
    }
}
