package com.generation.pruebawebquila.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category_Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CategoryProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name = "name_category", unique = true, nullable = false)
    private String nameCategory;
    @Column(name = "url_image_category", unique = true, nullable = false)
    private String urlImageCategory;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}

