package br.com.turma04.ctdcommerce.persistence.repositories;

import br.com.turma04.ctdcommerce.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.category.name LIKE %?1%")
    List<Product> findAllByCategory(String category);
}
