package org.a1aska17.bookhub.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookRequest {
    @NotBlank
    private String titleBook;
    @NotBlank
    private String authorBook;
    private String descriptionBook;

    @NotNull
    @Max(value = 2026)
    private int publicationYearBook;
}
