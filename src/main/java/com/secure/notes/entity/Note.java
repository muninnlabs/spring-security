package com.secure.notes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data; // 1. Check this import
import lombok.NoArgsConstructor;

@Entity
@Data // <--- This generates the "symbols" (methods) your Service is looking for lombok
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    private String ownerUsername;
}