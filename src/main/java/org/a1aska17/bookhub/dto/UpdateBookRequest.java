package org.a1aska17.bookhub.dto;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private String titleBook;
    private String authorBook;
    private String descriptionBook;
    private int publicationYearBook;
    private boolean isRead;
}
