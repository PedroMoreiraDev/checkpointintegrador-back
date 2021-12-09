package br.com.turma04.ctdcommerce.persistence.repositories;

import br.com.turma04.ctdcommerce.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c.name FROM Category c")
    List<String> listCategories();

    @Query("SELECT c FROM Category c WHERE c.name = ?1")
    Category findByName(String name);

}
