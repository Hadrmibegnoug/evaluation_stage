package com.jeeapp.evaluationstagev2.controllers;


import com.jeeapp.evaluationstagev2.model.entities.Competence;
import com.jeeapp.evaluationstagev2.services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    @Autowired
    private CompetenceService service;

    @GetMapping
    public List<Competence> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competence> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competence create(@RequestBody Competence c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competence> update(@PathVariable Long id, @RequestBody Competence c) {
        return service.findById(id).map(existing -> {
            c.setId(id);
            return ResponseEntity.ok(service.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
