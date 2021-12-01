package br.com.turma04.ctdcommerce.repositories;

import br.com.turma04.ctdcommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.category.name LIKE %?1%")
    List<Product> findAllByCategory(String category);
}
