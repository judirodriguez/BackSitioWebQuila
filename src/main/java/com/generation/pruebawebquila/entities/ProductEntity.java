package com.generation.pruebawebquila.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // las anotaciones se parten con @ y con mayúsculas y sirven para marcar diferentes elementos o indicar a que pertenece en la bbd, sirve para identificar la clase
@Table(name = "product")//con esta anotación creamos el nombre de la tabla
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId; //productoId
    @Column(unique = true, nullable = false)
    private String name_product; //nombre_producto
    @Column(unique = true, nullable = false)
    private String description_product; //descripcion_producto

    @ManyToOne
    @JoinColumn(name = "category_id", unique = true, nullable = false)
    private CategoryProductEntity category;

    @ManyToOne
    @JoinColumn(name = "entrepreneur_id", unique = true, nullable = false)
    private EntrepreneurEntity entrepreneur;


}

