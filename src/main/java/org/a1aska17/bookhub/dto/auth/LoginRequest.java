package org.a1aska17.bookhub.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private String userEmail;
    @NotBlank
    private String userPassword;
}
