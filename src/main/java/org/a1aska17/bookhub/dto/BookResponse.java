package org.a1aska17.bookhub.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookResponse {
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookDescription;
    private Integer bookPublicationYear;
    private LocalDateTime bookCreatedAt;
    private boolean bookIsRead;
    private LocalDateTime bookUpdateAt;
}
