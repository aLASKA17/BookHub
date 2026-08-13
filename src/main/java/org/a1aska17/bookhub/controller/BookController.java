package org.a1aska17.bookhub.controller;

import lombok.Data;
import org.a1aska17.bookhub.dto.CreateBookRequest;
import org.a1aska17.bookhub.dto.UpdateBookRequest;
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
    public Book findBook(@PathVariable Long idBook) {
        return bookService.findBookById(idBook);
    }

    @GetMapping
    public List<Book> findListBooks() {
        return bookService.findListBooks();
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
