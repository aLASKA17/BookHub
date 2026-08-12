package org.a1aska17.bookhub.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBookRequest {
    private String titleBook;
    private String authorBook;
    private String descriptionBook;

    @NotNull
    @Min(1)
    @Max(2026)
    private int publicationYearBook;

    private boolean isRead;
}
