package com.jeeapp.evaluationstagev2.services;


import com.jeeapp.evaluationstagev2.model.entities.Competence;
import com.jeeapp.evaluationstagev2.repositories.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository repository;

    public List<Competence> findAll() {
        return repository.findAll();
    }

    public Optional<Competence> findById(Long id) {
        return repository.findById(id);
    }

    public Competence save(Competence c) {
        return repository.save(c);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
