package com.jeeapp.evaluationstage.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("stagiaire")
public class Stagiaire extends Personne {
    private String institution;
    @OneToMany(mappedBy = "stagiaire")
    private List<Periode> periodes;
    public Stagiaire() {super();}
    public Stagiaire(String institution) {this.institution = institution;}
    public String getInstitution() {return institution;}
    public void setInstitution(String institution) {this.institution = institution;}
}
