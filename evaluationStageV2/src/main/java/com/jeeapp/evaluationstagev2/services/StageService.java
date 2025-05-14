package com.jeeapp.evaluationstagev2.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jeeapp.evaluationstagev2.model.dto.*;
import com.jeeapp.evaluationstagev2.model.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jeeapp.evaluationstagev2.model.dto.EvaluationDto;
import com.jeeapp.evaluationstagev2.repositories.AppreciationRepository;
import com.jeeapp.evaluationstagev2.repositories.CategorieRepository;
import com.jeeapp.evaluationstagev2.repositories.CompetenceRepository;
import com.jeeapp.evaluationstagev2.repositories.EvaluationRepository;
import com.jeeapp.evaluationstagev2.repositories.PeriodeRepository;
import com.jeeapp.evaluationstagev2.repositories.PersonneRepository;
import com.jeeapp.evaluationstagev2.repositories.StageRepository;
import com.jeeapp.evaluationstagev2.repositories.StagiaireRepository;
import com.jeeapp.evaluationstagev2.repositories.TuteurRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private AppreciationRepository appreciationRepository;
    @Autowired
    private StagiaireRepository stagiaireRepository;
    @Autowired
    private TuteurRepository tuteurRepository;
    @Autowired
    private PeriodeRepository periodeRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private PersonneRepository personneRepository;

    @Transactional
    public ResponseEntity<EvaluationDto> createEvaluation(EvaluationRequestDto dto) {

        // 1. Stagiaire
        StagiaireDto stagiaireDto = dto.getStagiaire();
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setNom(stagiaireDto.getNom());
        stagiaire.setPrenom(stagiaireDto.getPrenom());
        stagiaire.setEmail(stagiaireDto.getEmail());
        stagiaire.setInstitution(stagiaireDto.getInstitution());
        stagiaire = stagiaireRepository.save(stagiaire);

        // 4. Tuteur
        TuteurDto tuteurDto = dto.getTuteur();
        Tuteur tuteur = new Tuteur();
        tuteur.setNom(tuteurDto.getNom());
        tuteur.setPrenom(tuteurDto.getPrenom());
        tuteur.setEmail(tuteurDto.getEmail());
        tuteur.setEntreprise(tuteurDto.getEntreprise());
        tuteur = tuteurRepository.save(tuteur);

        // 2. Stage
        StageDto stageDto = dto.getStage();
        Stage stage = new Stage();
        stage.setDescription(stageDto.getDescription());
        stage.setObjective(stageDto.getObjective());
        stage.setEntreprise(stageDto.getEntreprise());
        stage = stageRepository.save(stage);

        // 3. Periode
        PeriodeDto periodeDto = dto.getPeriode();
        PeriodeId periodeId = new PeriodeId(stage.getstage_id(), stagiaire.getId());
        Periode periode = new Periode();
        periode.setId(periodeId);
        periode.setStagiaire(stagiaire);
        periode.setStage(stage);
        periode.setDateDebut(periodeDto.getDateDebut());
        periode.setDateFin(periodeDto.getDateFin());
        periode = periodeRepository.save(periode);

        // 5. Appreciation
        AppreciationDto appreciationDto = dto.getAppreciation();
        AppreciationId appreciationId = new AppreciationId(tuteur.getId(), periodeId);
        Appreciation appreciation = new Appreciation();
        appreciation.setAppreciationId(appreciationId);
        appreciation.setTuteur(tuteur);
        appreciation.setPeriode(periode);
        appreciation.setAppreciationName(appreciationDto.getAppreciationName());
        appreciation = appreciationRepository.save(appreciation);

        // 6. Evaluations
        Appreciation finalAppreciation = appreciation;
        List<Evaluation> evaluations = dto.getEvaluations().stream().map(e -> {
            Evaluation eval = new Evaluation();
            eval.setCategorie(e.getCategorie());
            eval.setValeur(e.getValeur());
            eval.setAppreciation(finalAppreciation);
            return eval;
        }).collect(Collectors.toList());

        evaluationRepository.saveAll(evaluations);
        appreciation.setEvaluations(evaluations);

        // 7. Compétences et catégories
        Appreciation finalAppreciation1 = appreciation;
        List<Competence> competences = dto.getCompetences().stream().map(c -> {
            Competence comp = new Competence();
            comp.setIntitule(c.getIntitule());
            comp.setNote(c.getNote());
            comp.setAppreciation(finalAppreciation1);
            comp = competenceRepository.save(comp);

            if (c.getCategories() != null) {
                Competence finalComp = comp;
                List<Categorie> categories = c.getCategories().stream().map(catDto -> {
                    Categorie cat = new Categorie();
                    cat.setIntitule(catDto.getIntitule());
                    cat.setValeur(catDto.getValeur());
                    cat.setCompetence(finalComp);
                    return cat;
                }).collect(Collectors.toList());

                categorieRepository.saveAll(categories);
                comp.setCategories(categories);
            }

            return comp;
        }).collect(Collectors.toList());

        appreciation.setCompetences(competences);

        // 8. Retour DTO
        return ResponseEntity.ok(EvaluationDto.toDto(appreciation));
    }
}
