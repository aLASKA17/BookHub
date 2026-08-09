package org.a1aska17.bookhub.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Table(schema = "public", name="Books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    @NotNull
    private String titleBook;
    private String authorBook;
    private String descriptionBook;
    private int publicationYearBook;
    private LocalDateTime createdAtBook;
    private boolean isRead;
    private LocalDateTime updateAtBook;

    @PrePersist
    public void addBook() {
        this.createdAtBook = LocalDateTime.now();
        this.updateAtBook = LocalDateTime.now();
    }

    @PreUpdate
    public void updateBook() {
        this.updateAtBook = LocalDateTime.now();
    }
}
