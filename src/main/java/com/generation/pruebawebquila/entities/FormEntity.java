package com.generation.pruebawebquila.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contactForm")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FormId;

    @Column(name = "name_contact", nullable = false)
    private String name;

    @Column(name = "email_contact", nullable = false)
    private String email;

    @Column(name = "telephone_contact")
    private String telephone;

    @Column(name = "message_subject", nullable = false)
    private String subject;

    @Column(name = "message_content", nullable = false)
    private String message;


}
