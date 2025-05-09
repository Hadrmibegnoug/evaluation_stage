package com.jeeapp.evaluationstage.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class AppreciationId {
    private String entreprise;
    private PeriodeId periodeId;
    public AppreciationId() {super();}
    public AppreciationId(String entreprise, PeriodeId periodeId) {this.entreprise = entreprise;this.periodeId = periodeId;}
    public String getEntreprise() {return entreprise;}
    public void setEntreprise(String entreprise) {this.entreprise = entreprise;}
    public PeriodeId getPeriodeId() {return periodeId;}
    public void setPeriodeId(PeriodeId periodeId) {this.periodeId = periodeId;}
}
