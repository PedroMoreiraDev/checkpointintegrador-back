package br.com.turma04.ctdcommerce.services.impl;

import br.com.turma04.ctdcommerce.dto.CategoryDTO;
import br.com.turma04.ctdcommerce.persistence.entities.Category;
import br.com.turma04.ctdcommerce.persistence.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository repository;

    public List<String> listCategories() {
        List<String> categories = repository.listCategories();
        return categories;
    }

    @Transactional
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = new Category(
                null,
                categoryDTO.getName()
        );
        category = repository.save(category);
        return new CategoryDTO(category);
    }
}
