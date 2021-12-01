package br.com.turma04.ctdcommerce.services;

import br.com.turma04.ctdcommerce.dto.ProductDTO;
import br.com.turma04.ctdcommerce.entities.Product;
import br.com.turma04.ctdcommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).orElse(null);
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAllByCategory(String category) {
        List<Product> products = repository.findAllByCategory(category);
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
