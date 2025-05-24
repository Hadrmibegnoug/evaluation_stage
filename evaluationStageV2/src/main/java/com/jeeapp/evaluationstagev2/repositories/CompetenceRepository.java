package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Appreciation;
import com.jeeapp.evaluationstagev2.model.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<Competence> findByAppreciation(Appreciation appreciation);
}
