package com.jeeapp.evaluationstagev2.services;

import com.jeeapp.evaluationstagev2.model.entities.Evaluation;
import com.jeeapp.evaluationstagev2.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository repository;

    public List<Evaluation> findAll() {
        return repository.findAll();
    }

    public Optional<Evaluation> findById(Long id) {
        return repository.findById(id);
    }

    public Evaluation save(Evaluation e) {
        return repository.save(e);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
