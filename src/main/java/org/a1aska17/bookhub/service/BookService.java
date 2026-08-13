package org.a1aska17.bookhub.service;

import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.dto.CreateBookRequest;
import org.a1aska17.bookhub.dto.UpdateBookRequest;
import org.a1aska17.bookhub.entity.Book;
import org.a1aska17.bookhub.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(CreateBookRequest createBookRequest) {
        Book book = new Book();
        book.setTitleBook(createBookRequest.getTitleBook());
        book.setAuthorBook(createBookRequest.getAuthorBook());
        book.setPublicationYearBook(createBookRequest.getPublicationYearBook());
        book.setDescriptionBook(createBookRequest.getDescriptionBook());
        book.setRead(false);
        return bookRepository.save(book);
    }

    public Book infoBookById(Long idBook) {
        return bookRepository.findByIdBook(idBook).
                orElseThrow(() -> new RuntimeException("Книга не найдена!"));
    }

    public List<Book> printListBooks() {
        return bookRepository.findAll();
    }

    public Book updateBookById(Long idBook, UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findByIdBook(idBook).orElseThrow(() -> new RuntimeException("Книга с id " + idBook + " не найдена"));

        if (updateBookRequest.getAuthorBook() != null) {
            book.setAuthorBook(updateBookRequest.getAuthorBook());
        }

        if (updateBookRequest.getDescriptionBook() != null) {
            book.setDescriptionBook(updateBookRequest.getDescriptionBook());
        }

        if (updateBookRequest.getPublicationYearBook() != 0) {
            book.setPublicationYearBook(updateBookRequest.getPublicationYearBook());
        }

        if (updateBookRequest.getTitleBook() != null) {
            book.setTitleBook(updateBookRequest.getTitleBook());
        }

        book.setRead(updateBookRequest.isRead());
        return bookRepository.save(book);
    }

    public void deleteBookById(Long idBook) {
        Book book = bookRepository.findByIdBook(idBook).orElseThrow(() -> new RuntimeException("Книга с id " + idBook + " не найдена"));
        bookRepository.delete(book);
    }
}
