package org.a1aska17.bookhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "public", name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotBlank
    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @NotBlank
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_created_at")
    private LocalDateTime userCreatedAt;

    @Column(name = "user_update_at")
    private LocalDateTime userUpdateAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "owner")
    private List<Book> books = new ArrayList<>();

    @PrePersist
    public void addUser() {
        this.userCreatedAt = LocalDateTime.now();
        this.userUpdateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void updateUser() {
        this.userCreatedAt = LocalDateTime.now();
    }
}
