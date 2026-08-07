package org.a1aska17.bookhub.service;

import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.dto.BookResponse;
import org.a1aska17.bookhub.entity.Book;
import org.a1aska17.bookhub.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public void addBook(BookResponse bookResponse) {
        Book book = new Book();
        book.setTitleBook(bookResponse.getTitleBook());
        book.setAuthorBook(bookResponse.getAuthorBook());
        book.setPublicationYearBook(bookResponse.getPublicationYearBook());
        book.setDescriptionBook(bookResponse.getDescriptionBook());
        book.setRead(false);
        bookRepository.save(book);
    }
}
