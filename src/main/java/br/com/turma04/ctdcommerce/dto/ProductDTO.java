package br.com.turma04.ctdcommerce.dto;

import br.com.turma04.ctdcommerce.persistence.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductDTO implements Serializable {

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String title, Double price, String description, String image, String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        title = product.getTitle();
        price = product.getPrice();
        description = product.getDescription();
        image = product.getImage();
        category = product.getCategory().getName();
    }
}
