package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuteurRepository extends JpaRepository<Tuteur, Long> {
    List<Tuteur> findByEmail(String email);
    List<Tuteur> findTuteurByEntreprise(String entreprise);
}
