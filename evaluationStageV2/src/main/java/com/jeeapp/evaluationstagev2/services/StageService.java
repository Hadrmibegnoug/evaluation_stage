package com.jeeapp.evaluationstagev2.services;

import com.jeeapp.evaluationstagev2.model.entities.Stage;
import com.jeeapp.evaluationstagev2.repositories.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {
    @Autowired
    private StageRepository repository;

    public List<Stage> findAll() {
        return repository.findAll();
    }

    public Stage create(Stage stage){return repository.save(stage);}

    public ResponseEntity<Stage> getStage(Long id){
        Stage stage = repository.findById(id).orElse(null);
        if (stage == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stage, HttpStatus.OK);
    }

    public ResponseEntity<Stage> updateStage(Long id, Stage stage){
        Stage s = repository.findById(id).orElse(null);
        if (s ==  null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        s.setDescription(stage.getDescription());
        s.setObjective(stage.getObjective());
        s.setEntreprise(stage.getEntreprise());
        repository.save(s);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteStage(Long id){
        Stage stage = repository.findById(id).orElse(null);
        if (stage == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(stage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Optional<Stage> findById(Long id) {
        return repository.findById(id);
    }

    public Stage save(Stage stage) {
        return repository.save(stage);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
