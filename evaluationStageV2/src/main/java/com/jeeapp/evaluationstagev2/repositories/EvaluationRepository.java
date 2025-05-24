package com.jeeapp.evaluationstagev2.repositories;

import com.jeeapp.evaluationstagev2.model.entities.Appreciation;
import com.jeeapp.evaluationstagev2.model.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByAppreciation(Appreciation appreciation);
}
