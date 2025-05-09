package com.jeeapp.evaluationstage.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Appreciation {
    @EmbeddedId
    private AppreciationId appreciationId;
    private String appreciationName;
    @ManyToOne
    private Periode periode;
    @ManyToOne
    private Tuteur tuteur;
    @OneToMany(mappedBy = "appreciation")
    private List<Evaluation> evaluations;
    @OneToMany(mappedBy = "appreciation")
    private List<Competence> competences;

    public Appreciation() {super();}
    public Appreciation(AppreciationId appreciationId, String appreciationName) {
        this.appreciationId = appreciationId;
        this.appreciationName = appreciationName;
    }
    public Appreciation(AppreciationId appreciationId, String appreciationName, Periode periode, Tuteur tuteur){
        this.appreciationId = appreciationId;
        this.appreciationName = appreciationName;
        this.periode = periode;
        this.tuteur = tuteur;
    }
    public AppreciationId getAppreciationId() {return appreciationId;}
    public void setAppreciationId(AppreciationId id) {
        this.appreciationId = id;
    }
    public String getAppreciationName() {return appreciationName;}
    public void setAppreciationName(String name) {this.appreciationName = name;}
    public Periode getPeriode() {return periode;}
    public void setPeriode(Periode periode) {this.periode = periode;}
    public Tuteur getTuteur() {return tuteur;}
    public void setTuteur(Tuteur tuteur) {this.tuteur = tuteur;}

}
