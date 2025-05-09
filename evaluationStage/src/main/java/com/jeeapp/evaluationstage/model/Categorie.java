package com.jeeapp.evaluationstage.model;


import jakarta.persistence.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String intitule;
    private String valeur;
    @ManyToOne
    private Competence competence;

    public Categorie() {super();}
    public Categorie(Long id, String intitule, String valeur, Competence competence) {
        super();
        this.id = id;
        this.intitule = intitule;
        this.valeur = valeur;
        this.competence = competence;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getIntitule() {return intitule;}
    public void setIntitule(String intitule) {this.intitule = intitule;}
    public String getValeur() {return valeur;}
    public void setValeur(String valeur) {this.valeur = valeur;}
    public Competence getCompetence() {return competence;}
    public void setCompetence(Competence competence) {this.competence = competence;}

}
