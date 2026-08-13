package org.a1aska17.bookhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotBlank
    private String userName;

    @NotBlank
    private String emailUser;

    @NotBlank
    private String passwordUser;

    private LocalDateTime createdAtUser;
    private LocalDateTime updateAtUser;

    @PrePersist
    public void addUser() {
        this.createdAtUser = LocalDateTime.now();
        this.updateAtUser = LocalDateTime.now();
    }

    @PreUpdate
    public void updateUser() {
        this.updateAtUser = LocalDateTime.now();
    }
}
