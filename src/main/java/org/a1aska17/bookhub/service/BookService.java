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
     // TODO исправить обновение не всех данных
    public Book updateBookById(Long idBook, UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findByIdBook(idBook).orElseThrow(() -> new RuntimeException("Книга с id " + idBook + " не найдена"));
        book.setRead(updateBookRequest.isRead());
        book.setDescriptionBook(updateBookRequest.getDescriptionBook());
        book.setPublicationYearBook(updateBookRequest.getPublicationYearBook());
        book.setAuthorBook(updateBookRequest.getAuthorBook());
        book.setTitleBook(updateBookRequest.getTitleBook());
        return bookRepository.save(book);
    }
}
