package br.com.turma04.ctdcommerce.repositories;

import br.com.turma04.ctdcommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
