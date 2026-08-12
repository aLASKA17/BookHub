package org.a1aska17.bookhub.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name="Books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    @NotBlank
    private String titleBook;

    @NotBlank
    private String authorBook;

    private String descriptionBook;

    @NotNull
    @Min(1)
    @Max(2026)
    @Max(2026)
    private Integer publicationYearBook;

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
