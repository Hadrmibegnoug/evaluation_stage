package com.jeeapp.evaluationstagev2.model.entities;


import com.jeeapp.evaluationstagev2.model.dto.AppreciationIdDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Appreciation {
    @EmbeddedId
    private AppreciationId appreciationId;
    private String appreciationName;
    @ManyToOne
    @MapsId("tuteurId")
    @JoinColumn(name = "tuteur_id")
    private Tuteur tuteur;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "stagiaire_id", referencedColumnName = "stagiaire_id", insertable = false, updatable = false),
            @JoinColumn(name = "stage_id", referencedColumnName = "stage_id", insertable = false, updatable = false)
    })
    private Periode periode;
    @OneToMany(mappedBy = "appreciation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
    @OneToMany(mappedBy = "appreciation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
    public List<Evaluation> getEvaluations() {return evaluations;}
    public void setEvaluations(List<Evaluation> evaluations) {this.evaluations = evaluations;}
    public List<Competence> getCompetences() {return competences;}
    public void setCompetences(List<Competence> competences) {this.competences = competences;}

}
