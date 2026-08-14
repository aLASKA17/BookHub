package org.a1aska17.bookhub.dto;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private String bookTitle;
    private String bookAuthor;
    private String bookDescription;
    private int bookPublicationYear;
    private boolean bookIsRead;
}
