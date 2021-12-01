package br.com.turma04.ctdcommerce.repositories;

import br.com.turma04.ctdcommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT DISTINCT c.name FROM Category c")
    List<String> listCategories();

}
