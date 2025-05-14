package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationRequestDto {
    private StagiaireDto stagiaire;
    private TuteurDto tuteur;
    private StageDto stage;
    private PeriodeDto periode;
    private AppreciationDto appreciation;

    private List<EvaluationItemDto> evaluations;
    private List<CompetenceItemDto> competences;

}
