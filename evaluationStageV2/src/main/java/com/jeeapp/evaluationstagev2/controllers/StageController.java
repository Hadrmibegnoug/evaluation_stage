package com.jeeapp.evaluationstagev2.controllers;


import com.jeeapp.evaluationstagev2.model.entities.Stage;
import com.jeeapp.evaluationstagev2.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Stage> getStageById(@PathVariable Long id) {
        Stage stage = service.getStage(id).getBody();
        return new ResponseEntity<>(stage, HttpStatus.OK);
    }

    @PostMapping
    public Stage createStage(@RequestBody Stage stage) {
        return service.create(stage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stage> update(@PathVariable Long id, @RequestBody Stage stage) {
        Stage s = service.updateStage(id, stage).getBody();
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
