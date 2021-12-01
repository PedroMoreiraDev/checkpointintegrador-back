package br.com.turma04.ctdcommerce.controllers;

import br.com.turma04.ctdcommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping
    public List<String> listCategories() {
        return service.listCategories();
    }
}

