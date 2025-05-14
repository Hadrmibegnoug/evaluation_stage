package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    List<Stagiaire> findByEmail(String email);
    List<Stagiaire> findByinstitution(String institution);
}
