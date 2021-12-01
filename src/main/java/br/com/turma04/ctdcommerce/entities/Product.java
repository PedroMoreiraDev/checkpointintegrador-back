package br.com.turma04.ctdcommerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
