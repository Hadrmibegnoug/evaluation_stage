package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Categorie;
import com.jeeapp.evaluationstagev2.model.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findByCompetence(Competence comp);
}
