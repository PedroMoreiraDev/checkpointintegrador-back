package br.com.turma04.ctdcommerce.services.impl;

import br.com.turma04.ctdcommerce.dto.ProductDTO;
import br.com.turma04.ctdcommerce.persistence.entities.Category;
import br.com.turma04.ctdcommerce.persistence.entities.Product;
import br.com.turma04.ctdcommerce.persistence.repositories.CategoryRepository;
import br.com.turma04.ctdcommerce.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Integer id) {
        Product product = repository.findById(id).orElse(null);
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAllByCategory(String category) {
        List<Product> products = repository.findAllByCategory(category);
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        Category category = categoryRepository.findByName(productDTO.getCategory());
        Product product = new Product(
                null,
                productDTO.getTitle(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                productDTO.getImage(),
                category
        );
        product = repository.save(product);
        return new ProductDTO(product);
    }
}
