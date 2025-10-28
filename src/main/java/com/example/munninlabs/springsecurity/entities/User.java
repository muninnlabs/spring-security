package com.example.munninlabs.springsecurity.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    @NonNull
    private String userName;

    @NonNull
    private String password;
    private String role;

    @NonNull
    private String email;
    private String provider;
    private String providerId;

    @Column(name = "profile_picture")
    private String profilePicture;
}
