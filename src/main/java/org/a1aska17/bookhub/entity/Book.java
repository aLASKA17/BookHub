package org.a1aska17.bookhub.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


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
    private LocalDate createdAtBook;
    private boolean isRead;
    private LocalDate updateAtBook;

    @PrePersist
    public void addBook() {
        this.createdAtBook = LocalDate.now();
        this.updateAtBook = LocalDate.now();
    }

    @PreUpdate
    public void updateBook() {
        this.updateAtBook = LocalDate.now();
    }
}
