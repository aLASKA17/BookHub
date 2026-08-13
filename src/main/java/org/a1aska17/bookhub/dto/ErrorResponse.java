package org.a1aska17.bookhub.dto;

import lombok.Getter;
import java.time.LocalDateTime;


@Getter
public class ErrorResponse {
    private final LocalDateTime timestampError;
    private final String statusError;
    private final String titleError;
    private final String pathError;

    public ErrorResponse(String statusError, String titleError, String pathError) {
        this.timestampError = LocalDateTime.now();
        this.statusError = statusError;
        this.titleError = titleError;
        this.pathError = pathError;
    }
}
