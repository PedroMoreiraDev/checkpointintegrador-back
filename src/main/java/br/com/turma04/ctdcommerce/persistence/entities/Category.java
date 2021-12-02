package br.com.turma04.ctdcommerce.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @Column(name="id")
    @SequenceGenerator(name="category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    private Integer id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}
