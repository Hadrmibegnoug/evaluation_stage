package com.jeeapp.evaluationstagev2.model.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("tuteur")
public class Tuteur extends Personne{
    private String entreprise;
    @OneToMany(mappedBy = "tuteur")
    private List <Appreciation> appreciations;
    public Tuteur() {super();}
    public Tuteur(String entreprise) {this.entreprise = entreprise;}
    public String getEntreprise() {return entreprise;}
    public void setEntreprise(String entreprise) {this.entreprise = entreprise;}

}
