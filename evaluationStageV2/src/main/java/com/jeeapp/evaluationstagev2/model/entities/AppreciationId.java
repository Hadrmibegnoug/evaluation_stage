package com.jeeapp.evaluationstagev2.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AppreciationId {
    @Column(name = "tuteur_id")
    private Long tuteurId;
    private PeriodeId periodeId;
    public AppreciationId() {super();}
    public AppreciationId(Long tuteurId, PeriodeId periodeId) {this.tuteurId = tuteurId;this.periodeId = periodeId;}
    public Long gettutteurId() {return tuteurId;}
    public void setEntreprise(Long tuteurId) {this.tuteurId = tuteurId;}
    public PeriodeId getPeriodeId() {return periodeId;}
    public void setPeriodeId(PeriodeId periodeId) {this.periodeId = periodeId;}
}
