package org.a1aska17.bookhub.service;

import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.dto.book.CreateBookRequest;
import org.a1aska17.bookhub.dto.book.UpdateBookRequest;
import org.a1aska17.bookhub.entity.Book;
import org.a1aska17.bookhub.exception.BookNotFoundException;
import org.a1aska17.bookhub.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(CreateBookRequest createBookRequest) {
        Book book = new Book();
        book.setBookTitle(createBookRequest.getBookTitle());
        book.setBookAuthor(createBookRequest.getBookAuthor());
        book.setBookPublicationYear(createBookRequest.getBookPublicationYear());
        book.setBookDescription(createBookRequest.getBookDescription());
        book.setBookIsRead(false);
        return bookRepository.save(book);
    }

    public Book findBookById(Long idBook) {
        return bookRepository.findByBookId(idBook).
                orElseThrow(() -> new BookNotFoundException("Книга с id " + idBook + " не найдена"));
    }

    public List<Book> findListBooks() {
        return bookRepository.findAll();
    }

    public Book updateBookById(Long idBook, UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findByBookId(idBook).orElseThrow(() -> new BookNotFoundException("Книга с id " + idBook + " не найдена"));

        if (updateBookRequest.getBookAuthor() != null) {
            book.setBookAuthor(updateBookRequest.getBookAuthor());
        }

        if (updateBookRequest.getBookDescription() != null) {
            book.setBookDescription(updateBookRequest.getBookDescription());
        }

        if (updateBookRequest.getBookPublicationYear() != 0) {
            book.setBookPublicationYear(updateBookRequest.getBookPublicationYear());
        }

        if (updateBookRequest.getBookTitle() != null) {
            book.setBookTitle(updateBookRequest.getBookTitle());
        }

        book.setBookIsRead(updateBookRequest.isBookIsRead());
        return bookRepository.save(book);
    }

    public void deleteBookById(Long idBook) {
        Book book = bookRepository.findByBookId(idBook).orElseThrow(() -> new BookNotFoundException("Книга с id " + idBook + " не найдена"));
        bookRepository.delete(book);
    }
}
