package com.jeeapp.evaluationstagev2.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PeriodeId {
    @Column(name = "stage_id")
    private Long stageId;
    @Column(name = "stagiaire_id")
    private Long stagiaireId;
    public PeriodeId() {super();}
    public PeriodeId(Long stage_id, Long stagiaire_id) {this.stageId = stage_id;this.stagiaireId = stagiaire_id;}
    public Long getStage_id() {return stageId;}
    public void setStage_id(Long stage_id) {this.stageId = stage_id;}
    public Long getStagiaire_id() {return stagiaireId;}
    public void setInstitution(Long stagiaire_id) {this.stagiaireId = stagiaire_id;}

}
