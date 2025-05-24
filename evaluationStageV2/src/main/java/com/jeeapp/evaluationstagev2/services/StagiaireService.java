package com.jeeapp.evaluationstagev2.services;

import com.jeeapp.evaluationstagev2.model.entities.Stagiaire;
import com.jeeapp.evaluationstagev2.repositories.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Stagiaire> getStagiaire(Long id) {
        Stagiaire stagiaire = repository.findById(id).orElse(null);
        if (stagiaire == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stagiaire, HttpStatus.OK);
    }

    public Stagiaire save(Stagiaire stagiaire) {
        return repository.save(stagiaire);
    }

    public ResponseEntity<Stagiaire> updateTuteur(Long id, Stagiaire stagiaire){
        Stagiaire s = repository.findById(id).orElse(null);
        if (s == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        s.setNom(stagiaire.getNom());
        s.setPrenom(stagiaire.getPrenom());
        s.setEmail(stagiaire.getEmail());
        s.setInstitution(stagiaire.getInstitution());
        repository.save(s);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    public ResponseEntity<Stagiaire> deleteStagiaire(Long id){
        Stagiaire stagiaire = repository.findById(id).orElse(null);
        if (stagiaire == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(stagiaire);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
