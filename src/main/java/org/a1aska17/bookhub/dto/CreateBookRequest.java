package org.a1aska17.bookhub.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookRequest {
    @NotBlank
    private String bookTitle;
    @NotBlank
    private String bookAuthor;
    private String bookDescription;

    @NotNull
    @Min(value = 0)
    @Max(value = 2026)
    private int bookPublicationYear;
}
