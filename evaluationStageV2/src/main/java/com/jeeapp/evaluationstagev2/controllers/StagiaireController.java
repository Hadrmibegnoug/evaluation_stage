package com.jeeapp.evaluationstagev2.controllers;

import com.jeeapp.evaluationstagev2.model.entities.Stagiaire;
import com.jeeapp.evaluationstagev2.services.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stagiaire create(@RequestBody Stagiaire s) {
        return service.save(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stagiaire> update(@PathVariable Long id, @RequestBody Stagiaire s) {
        return service.findById(id).map(existing -> {
            s.setId(id);
            return ResponseEntity.ok(service.save(s));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
