package com.jeeapp.evaluationstagev2.controllers;


import com.jeeapp.evaluationstagev2.model.entities.Stage;
import com.jeeapp.evaluationstagev2.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageController {
    @Autowired
    private StageService service;

    @GetMapping
    public List<Stage> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stage> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stage create(@RequestBody Stage stage) {
        return service.save(stage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stage> update(@PathVariable Long id, @RequestBody Stage stage) {
        return service.findById(id).map(existing -> {
            stage.setId(id);
            return ResponseEntity.ok(service.save(stage));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
