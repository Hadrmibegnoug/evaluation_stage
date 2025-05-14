package com.jeeapp.evaluationstagev2.model.entities;


import jakarta.persistence.*;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categorie;
    private String valeur;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "tuteur_id", referencedColumnName = "tuteur_id"),
            @JoinColumn(name = "stagiaire_id", referencedColumnName = "stagiaire_id"),
            @JoinColumn(name = "stage_id", referencedColumnName = "stage_id")
    })
    private Appreciation appreciation;


    public Evaluation() {super();}
    public Evaluation(Long id, String categorie, String valeur, Appreciation appreciation) {
        this.id = id;
        this.categorie = categorie;
        this.valeur = valeur;
        this.appreciation = appreciation;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getCategorie() {return categorie;}
    public void setCategorie(String categorie) {this.categorie = categorie;}
    public String getValeur() {return valeur;}
    public void setValeur(String valeur) {this.valeur = valeur;}
    public Appreciation getAppreciation() {return appreciation;}
    public void setAppreciation(Appreciation appreciation) {this.appreciation = appreciation;}

}
