package com.jeeapp.evaluationstage.repositories;

import com.jeeapp.evaluationstage.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuteurRepository extends JpaRepository<Tuteur, Long> {
    List<Tuteur> findByEmail(String email);
    List<Tuteur> findTuteurByEntreprise(String entreprise);
}
