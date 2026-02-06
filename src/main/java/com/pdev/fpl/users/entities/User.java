package com.pdev.fpl.users.entities;

import com.pdev.fpl.users.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // role for authorization
    @Enumerated(EnumType.STRING)
    private Roles roles = Roles.USER;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}
