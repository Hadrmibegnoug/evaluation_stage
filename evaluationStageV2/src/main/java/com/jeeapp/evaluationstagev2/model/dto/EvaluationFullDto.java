package com.jeeapp.evaluationstagev2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationFullDto {
    private StagiaireDto stagiaire;
    private TuteurDto tuteur;
    private StageDto stage;
    private PeriodeDto periode;
    private AppreciationDto appreciation;
    private List<EvaluationItemDto> evaluations;
    private List<CompetenceItemDto> competences;
}

