package com.jeeapp.evaluationstagev2.services;

import com.jeeapp.evaluationstagev2.model.entities.Stagiaire;
import com.jeeapp.evaluationstagev2.repositories.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {
    @Autowired
    private StagiaireRepository repository;

    public List<Stagiaire> findAll() {
        return repository.findAll();
    }

    public Optional<Stagiaire> findById(Long id) {
        return repository.findById(id);
    }

    public Stagiaire save(Stagiaire stagiaire) {
        return repository.save(stagiaire);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
