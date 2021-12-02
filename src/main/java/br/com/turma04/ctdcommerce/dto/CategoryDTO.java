package br.com.turma04.ctdcommerce.dto;

import br.com.turma04.ctdcommerce.persistence.entities.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoryDTO implements Serializable {

    private Integer id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
    }
}
