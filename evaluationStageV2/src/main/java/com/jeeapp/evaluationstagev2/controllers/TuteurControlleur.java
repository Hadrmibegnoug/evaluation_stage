package com.jeeapp.evaluationstagev2.controllers;

import com.jeeapp.evaluationstagev2.model.entities.Tuteur;
import com.jeeapp.evaluationstagev2.services.TuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TuteurControlleur {
    @Autowired
    private TuteurService tuteurService;

    @GetMapping("/tuteur")
    public List<Tuteur> getTuteurService() {return tuteurService.findAll();}

    @PostMapping("/tuteur")
    public Tuteur createTuteur(@RequestBody Tuteur tuteur) {
        return tuteurService.create(tuteur);
    }
    @GetMapping("/tuteur/{id}")
    public ResponseEntity<Tuteur> getTuteurById(@PathVariable Long id) {
        Tuteur tuteur = tuteurService.getTuteur(id).getBody();
        return new ResponseEntity<>(tuteur, HttpStatus.OK);
    }

    @PutMapping("/tuteur/{id}")
    public ResponseEntity<Tuteur> updateTuteur(@PathVariable Long id, @RequestBody Tuteur tuteur) {
        Tuteur t = tuteurService.updateTuteur(id, tuteur).getBody();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @DeleteMapping("/tuteur/{id}")
    public ResponseEntity<Void> deleteTuteur(@PathVariable Long id) {
        tuteurService.deleteTuteur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
