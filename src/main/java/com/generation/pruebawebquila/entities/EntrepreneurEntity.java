package com.generation.pruebawebquila.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "entrepreneur")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class EntrepreneurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entrepreneurId;

    @Column(name = "name_entrepreneur", unique = true, nullable = false)
    private String nameEntrepreneur;

    @Column(name = "name_entrepreneurship") //no se coloca la condición porque hay emprendedores que no tienen nombre a su emprendimiento
    private  String nameEntrepreneurship;

    @Column(name = "history_entrepreneur", unique = true, nullable = false)
    private String historyEntrepreneur;

    @Column(name = "url_image_entrepreneur", unique = true, nullable = false)
    private String urlImageEntrepreneur;

    @OneToMany(mappedBy = "entrepreneur")
    private List<ProductEntity> products;

}
