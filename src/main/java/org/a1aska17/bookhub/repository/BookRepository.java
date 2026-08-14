package org.a1aska17.bookhub.repository;

import org.a1aska17.bookhub.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    //Optional<Book> findByAuthor (String authorBook);
    Optional<Book> findByBookId (Long bookId);
}
