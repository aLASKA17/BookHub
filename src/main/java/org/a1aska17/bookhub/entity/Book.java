package org.a1aska17.bookhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NotBlank
    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @NotBlank
    @Column(name = "book_author", nullable = false)
    private String bookAuthor;

    @Column(name = "book_description", nullable = false)
    private String bookDescription;

    @NotNull
    @Min(1)
    @Max(2026)
    @Column(name = "book_publication_year", nullable = false)
    private Integer bookPublicationYear;

    @Column(name = "book_created_at")
    private LocalDateTime bookCreatedAt;

    @Column(name = "book_is_read")
    private boolean bookIsRead;

    @Column(name = "book_update_at")
    private LocalDateTime bookUpdateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User owner;

    @PrePersist
    public void addBook() {
        this.bookCreatedAt = LocalDateTime.now();
        this.bookUpdateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void updateBook() {
        this.bookUpdateAt = LocalDateTime.now();
    }
}
