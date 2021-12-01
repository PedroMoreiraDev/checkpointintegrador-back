package br.com.turma04.ctdcommerce.repositories;

import br.com.turma04.ctdcommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
