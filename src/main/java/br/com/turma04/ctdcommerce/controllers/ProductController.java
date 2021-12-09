package br.com.turma04.ctdcommerce.controllers;


import br.com.turma04.ctdcommerce.dto.CategoryDTO;
import br.com.turma04.ctdcommerce.dto.ProductDTO;
import br.com.turma04.ctdcommerce.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ProductDTO> createCategory(@RequestBody ProductDTO product) {
        ProductDTO productDTO = service.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(productDTO);
    }
}
