package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {
    private StagiaireDto stagiaire;
    private TuteurDto tuteur;
    private StageDto stage;
    private PeriodeDto periode;
    private AppreciationDto appreciation;

    private List<EvaluationItemDto> evaluations;
    private List<CompetenceItemDto> competences;

    public static EvaluationDto toDto(Appreciation appreciation) {
        Periode periode = appreciation.getPeriode();
        Stage stage = periode.getStage();
        Stagiaire stagiaire = periode.getStagiaire();
        Tuteur tuteur = appreciation.getTuteur();

        return EvaluationDto.builder()
                .stagiaire(StagiaireDto.builder()
                        .stagiaireId(stagiaire.getId())
                        .nom(stagiaire.getNom())
                        .prenom(stagiaire.getPrenom())
                        .email(stagiaire.getEmail())
                        .institution(stagiaire.getInstitution())
                        .build())

                .tuteur(TuteurDto.builder()
                        .tuteurId(tuteur.getId())
                        .nom(tuteur.getNom())
                        .prenom(tuteur.getPrenom())
                        .email(tuteur.getEmail())
                        .entreprise(tuteur.getEntreprise())
                        .build())

                .stage(StageDto.builder()
                        .stageId(stage.getstage_id())
                        .description(stage.getDescription())
                        .objective(stage.getObjective())
                        .entreprise(stage.getEntreprise())
                        .build())
                .periode(PeriodeDto.builder()
                        .periodeId(new PeriodeId(stage.getstage_id(), stagiaire.getId()))
                        .dateDebut(periode.getDateDebut())
                        .dateFin(periode.getDateFin())
                        .build())

                .appreciation(AppreciationDto.builder()
                        .appreciationId(new AppreciationIdDto(tuteur.getId(),
                                new PeriodeIdDto(stage.getstage_id(), stagiaire.getId())))
                        .appreciationName(appreciation.getAppreciationName())
                        .build())

                .evaluations(appreciation.getEvaluations().stream()
                        .map(e -> EvaluationItemDto.builder()
                                .categorie(e.getCategorie())
                                .valeur(e.getValeur())
                                .build())
                        .collect(Collectors.toList()))

                .competences(appreciation.getCompetences().stream()
                        .map(c -> CompetenceItemDto.builder()
                                .intitule(c.getIntitule())
                                .note(c.getNote())
                                .categories(
                                        c.getCategories().stream()
                                                .map(cat -> CategorieItemDto.builder()
                                                        .intitule(cat.getIntitule())
                                                        .valeur(cat.getValeur())
                                                        .build())
                                                .collect(Collectors.toList())
                                )
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}

/*public class EvaluationDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private AppreciationId appreciationId;
    private String appreciationName;
    private Periode periode;
    private Tuteur tuteur;
    private Long idCategory;
    private String intituleCategorie;
    private String valeur;
    private Long idComp;
    private String intituleComp;
    private String note;
    private Appreciation appreciation;
    private Long idEvaluation;
    private String categorie;
    private String valeurEvaluation;
    private Appreciation appreciationEvaluation;
    private PeriodeId periodeId;
    private Stagiaire stagiaire;
    private Stage stage;
    private String dateDebut;
    private String dateFin;
    private Long stage_id;
    private String description;
    private String objective;
    private String entreprise;
    private String institution;
    private String entrepriseTuteur;

    public static EvaluationDto toDto(Evaluation evaluation,
                               Personne personne,
                               Appreciation appreciation,
                               Stage stage,
                               Stagiaire stagiaire, Tuteur tuteur,
                               Periode periode, Competence competence, Categorie categorie) {
        return EvaluationDto.builder()
                .id(personne.getId())
                .nom(personne.getNom())
                .prenom(personne.getPrenom())
                .email(personne.getEmail())
                .appreciationId(appreciation.getAppreciationId())
                .appreciationName(appreciation.getAppreciationName())
                .periode(appreciation.getPeriode())
                .tuteur(appreciation.getTuteur())
                .idCategory(categorie.getId())
                .intituleCategorie(categorie.getIntitule())
                .valeur(categorie.getValeur())
                .idComp(competence.getId())
                .intituleComp(competence.getIntitule())
                .note(competence.getNote())
                .appreciation(competence.getAppreciation())
                .idEvaluation(evaluation.getId())
                .categorie(evaluation.getCategorie())
                .valeurEvaluation(evaluation.getValeur())
                .appreciationEvaluation(evaluation.getAppreciation())
                .periodeId(periode.getId())
                .stagiaire(periode.getStagiaire())
                .stage(periode.getStage())
                .dateDebut(periode.getDateDebut())
                .dateFin(periode.getDateFin())
                .stage_id(stage.getstage_id())
                .description(stage.getDescription())
                .objective(stage.getObjective())
                .entreprise(stage.getEntreprise())
                .institution(stagiaire.getInstitution())
                .entrepriseTuteur(tuteur.getEntreprise())
                .build();
    }
}*/
