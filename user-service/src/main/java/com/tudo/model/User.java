package com.tudo.model;

import com.tudo.domain.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is Required")
    @Email(message = "Enter a valid Email ID")
    private String email;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @NotBlank(message = "Password is Required")
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}