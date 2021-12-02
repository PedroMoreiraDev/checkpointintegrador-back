package br.com.turma04.ctdcommerce.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title", length = 50, nullable = false)
    private String title;

    @Column(name="price", precision=10, scale=2, nullable = false)
    private Double price;

    @Column(name="description", length = 255, nullable = false)
    private String description;

    @Column(name="image", length = 255, nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String title, Double price, String description, String image, Category category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }
}
