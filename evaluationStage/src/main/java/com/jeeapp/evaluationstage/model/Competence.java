package com.jeeapp.evaluationstage.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String intitule;
    private String note;
    @ManyToOne
    private Appreciation appreciation;
    @OneToMany(mappedBy = "competence")
    private List<Categorie> categories;

    public Competence() {super();}
    public Competence(Long id, String intitule, String note, Appreciation appreciation) {
        super();
        this.id = id;
        this.intitule = intitule;
        this.note = note;
        this.appreciation = appreciation;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getIntitule() {return intitule;}
    public void setIntitule(String intitule) {this.intitule = intitule;}
    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}

}
