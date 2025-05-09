package com.jeeapp.evaluationstage.repositories;

import com.jeeapp.evaluationstage.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
