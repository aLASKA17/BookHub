package org.a1aska17.bookhub.controller;

import org.a1aska17.bookhub.dto.CreateBookRequest;
import org.a1aska17.bookhub.dto.UpdateBookRequest;
import org.a1aska17.bookhub.entity.Book;
import org.a1aska17.bookhub.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody CreateBookRequest createBookRequest) {
       return bookService.addBook(createBookRequest);
    }

    @GetMapping("/{idBook}")
    public Book infoBook(@PathVariable Long idBook) {
        return bookService.infoBookById(idBook);
    }

    @GetMapping
    public List<Book> printListBooks() {
        return bookService.printListBooks();
    }

    @PutMapping("/{idBook}")
    public Book updateBook(@PathVariable Long idBook, @RequestBody UpdateBookRequest updateBookRequest) {
        return bookService.updateBookById(idBook, updateBookRequest);
    }

    @DeleteMapping("/{idBook}")
    public void deleteBook(@PathVariable Long idBook) {
        bookService.deleteBookById(idBook);
    }
}
