package com.jeeapp.evaluationstage.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PeriodeId {
    private Long stage_id;
    private String institution;
    public PeriodeId() {super();}
    public PeriodeId(Long stage_id, String institution) {this.stage_id = stage_id;this.institution = institution;}
    public Long getStage_id() {return stage_id;}
    public void setStage_id(Long stage_id) {this.stage_id = stage_id;}
    public String getInstitution() {return institution;}
    public void setInstitution(String institution) {this.institution = institution;}

}
