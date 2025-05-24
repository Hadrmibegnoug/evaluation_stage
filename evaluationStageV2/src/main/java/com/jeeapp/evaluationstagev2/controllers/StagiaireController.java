package com.jeeapp.evaluationstagev2.controllers;

import com.jeeapp.evaluationstagev2.model.entities.Stagiaire;
import com.jeeapp.evaluationstagev2.services.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagiaires")
public class StagiaireController {

    @Autowired
    private StagiaireService service;

    @GetMapping
    public List<Stagiaire> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stagiaire> getById(@PathVariable Long id) {
        Stagiaire stagiaire = service.getStagiaire(id).getBody();
        return new ResponseEntity<>(stagiaire, HttpStatus.OK);
    }

    @PostMapping
    public Stagiaire create(@RequestBody Stagiaire s) {
        return service.save(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stagiaire> update(@PathVariable Long id, @RequestBody Stagiaire s) {
        Stagiaire stagiaire = service.updateTuteur(id, s).getBody();
        return new ResponseEntity<>(stagiaire ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStagiaire(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
