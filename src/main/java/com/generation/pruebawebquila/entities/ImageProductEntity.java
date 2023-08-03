package com.generation.pruebawebquila.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "image_Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class ImageProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_Product_Id;

    @ManyToOne
    @JoinColumn(name = "product_Id", unique = true, nullable = false)
    private ProductEntity product;

    @Column(name = "url_image_product", unique = true, nullable = false)
    private String urlImageProduct;




}
