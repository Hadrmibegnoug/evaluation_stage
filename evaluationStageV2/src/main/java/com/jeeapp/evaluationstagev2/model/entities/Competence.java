package com.jeeapp.evaluationstagev2.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String intitule;
    private String note;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "tuteur_id", referencedColumnName = "tuteur_id"),
            @JoinColumn(name = "stagiaire_id", referencedColumnName = "stagiaire_id"),
            @JoinColumn(name = "stage_id", referencedColumnName = "stage_id")
    })
    private Appreciation appreciation;
    @OneToMany(mappedBy = "competence", fetch = FetchType.EAGER)
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
    public Appreciation getAppreciation() {return appreciation;}
    public void setAppreciation(Appreciation appreciation) {this.appreciation = appreciation;}
    public List<Categorie> getCategories() {return categories;}
    public void setCategories(List<Categorie> categories) {this.categories = categories;}

}
