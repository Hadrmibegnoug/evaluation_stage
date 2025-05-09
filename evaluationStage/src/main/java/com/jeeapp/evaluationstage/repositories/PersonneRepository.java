package com.jeeapp.evaluationstage.repositories;

import com.jeeapp.evaluationstage.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Optional<Personne> findByEmail(String email);
}
