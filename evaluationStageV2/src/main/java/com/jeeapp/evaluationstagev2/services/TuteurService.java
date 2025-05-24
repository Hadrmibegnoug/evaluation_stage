package com.jeeapp.evaluationstagev2.services;

import com.jeeapp.evaluationstagev2.model.entities.Tuteur;
import com.jeeapp.evaluationstagev2.repositories.TuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuteurService {
    @Autowired
    private TuteurRepository tuteurRepository;
    public List<Tuteur> findAll() {
        return tuteurRepository.findAll();
    }

    public Tuteur create(Tuteur tuteur) {
        return tuteurRepository.save(tuteur);
    }

    public ResponseEntity<Tuteur> getTuteur(Long id) {
        Tuteur tuteur = tuteurRepository.findById(id).orElse(null);
        if (tuteur == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tuteur, HttpStatus.OK);
    }

    public ResponseEntity<Tuteur> updateTuteur(Long id, Tuteur tuteur) {
        Tuteur t = tuteurRepository.findById(id).orElse(null);
        if (t == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        t.setNom(tuteur.getNom());
        t.setPrenom(tuteur.getPrenom());
        t.setEmail(tuteur.getEmail());
        t.setEntreprise(tuteur.getEntreprise());
        tuteurRepository.save(t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteTuteur(Long id) {
        Tuteur tuteur = tuteurRepository.findById(id).orElse(null);
        if (tuteur == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tuteurRepository.delete(tuteur);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
