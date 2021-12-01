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
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
