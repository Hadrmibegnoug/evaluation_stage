package com.jeeapp.evaluationstagev2.controllers;

import com.jeeapp.evaluationstagev2.model.entities.Evaluation;
import com.jeeapp.evaluationstagev2.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations/simple")
public class EvaluationController {
    @Autowired
    private EvaluationService service;

    @GetMapping
    public List<Evaluation> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Evaluation create(@RequestBody Evaluation e) {
        return service.save(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> update(@PathVariable Long id, @RequestBody Evaluation e) {
        return service.findById(id).map(existing -> {
            e.setId(id);
            return ResponseEntity.ok(service.save(e));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
