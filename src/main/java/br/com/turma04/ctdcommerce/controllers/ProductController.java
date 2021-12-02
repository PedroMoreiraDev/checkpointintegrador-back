package br.com.turma04.ctdcommerce.controllers;


import br.com.turma04.ctdcommerce.dto.ProductDTO;
import br.com.turma04.ctdcommerce.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) {
        ProductDTO product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<ProductDTO>> findAllByCategory(@PathVariable String name) {
        List<ProductDTO> products = service.findAllByCategory(name);
        return ResponseEntity.ok().body(products);
    }
}
