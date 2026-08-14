package org.a1aska17.bookhub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "public", name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true)
    private RoleName roleName;
}
