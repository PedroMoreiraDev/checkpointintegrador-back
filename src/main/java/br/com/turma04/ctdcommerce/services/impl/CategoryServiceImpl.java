package br.com.turma04.ctdcommerce.services.impl;

import br.com.turma04.ctdcommerce.persistence.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository repository;

    public List<String> listCategories() {
        List<String> categories = repository.listCategories();
        return categories;
    }

}
