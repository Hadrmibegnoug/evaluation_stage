package com.jeeapp.evaluationstagev2.controllers;

import com.jeeapp.evaluationstagev2.model.dto.EvaluationDto;
import com.jeeapp.evaluationstagev2.model.dto.EvaluationFullDto;
import com.jeeapp.evaluationstagev2.model.dto.EvaluationRequestDto;
import com.jeeapp.evaluationstagev2.services.EvaluationStagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations") // facultatif selon frontend
public class EvaluationStagiaireController {
    @Autowired
    private EvaluationStagiaire stageService;

    @PostMapping("/create")
    public ResponseEntity<EvaluationDto> createEvaluation(@RequestBody EvaluationRequestDto evaluationRequestDto) {
        return stageService.createEvaluation(evaluationRequestDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EvaluationDto>> getAllEvaluationsFull() {
        return ResponseEntity.ok(stageService.getAllEvaluationsFull());
    }


}
