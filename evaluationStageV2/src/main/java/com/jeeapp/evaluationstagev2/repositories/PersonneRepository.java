package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Optional<Personne> findByEmail(String email);
}
