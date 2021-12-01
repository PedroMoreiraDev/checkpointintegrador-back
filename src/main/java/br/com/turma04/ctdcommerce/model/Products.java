package br.com.turma04.ctdcommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private String title;
    private int price;
    private String description;
    private String image;
    private Categories category;

}
