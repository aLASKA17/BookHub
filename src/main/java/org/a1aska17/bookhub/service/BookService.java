package org.a1aska17.bookhub.service;

import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.dto.BookResponse;
import org.a1aska17.bookhub.entity.Book;
import org.a1aska17.bookhub.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(BookResponse bookResponse) {
        Book book = new Book();
        book.setTitleBook(bookResponse.getTitleBook());
        book.setAuthorBook(bookResponse.getAuthorBook());
        book.setPublicationYearBook(bookResponse.getPublicationYearBook());
        book.setDescriptionBook(bookResponse.getDescriptionBook());
        book.setRead(false);
        return bookRepository.save(book);
    }

    public Book infoBookById(BookResponse bookResponse) {
        return bookRepository.findByIdBook(bookResponse.getIdBook()).
                orElseThrow(() -> new RuntimeException("Книга не найдена!"));
    }

    public List<Book> printListBooks() {
        return bookRepository.findAll();
    }
}
