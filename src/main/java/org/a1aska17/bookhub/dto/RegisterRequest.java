package org.a1aska17.bookhub.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String userEmail;
    @NotBlank
    private String userPassword;
}
