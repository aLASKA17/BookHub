package org.a1aska17.bookhub.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookResponse {
    private Long idBook;
    private String titleBook;
    private String authorBook;
    private String descriptionBook;
    private Integer publicationYearBook;
    private LocalDateTime createdAtBook;
    private boolean isRead;
    private LocalDateTime updateAtBook;
}
