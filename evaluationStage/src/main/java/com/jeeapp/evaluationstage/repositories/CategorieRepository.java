package com.jeeapp.evaluationstage.repositories;

import com.jeeapp.evaluationstage.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
