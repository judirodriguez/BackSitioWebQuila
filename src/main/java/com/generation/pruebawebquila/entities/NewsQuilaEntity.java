package com.generation.pruebawebquila.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NewsQuila")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class NewsQuilaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NewsQuilaId;

    @Column(name = "headline_news", nullable = false)
    private String headlineNews;

    @Column(name = "download_news", nullable = false)
    private String downloasNews;

    @Column(name = "news_body", nullable = false)
    private String newsbody;

    @Column(name = "news_image", nullable = false)
    private String newsImage;

}
