package com.jeeapp.evaluationstagev2.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stage_id;

    private String description;
    private String objective;
    private String entreprise;
    @OneToMany(mappedBy = "stage")
    private List<Periode> periodes;

    public Stage() {super();}
    public Stage(Long stage_id,String description, String objective, String entreprise) {
        super();
        this.stage_id = stage_id;
        this.description = description;
        this.objective = objective;
        this.entreprise = entreprise;
    }

    public Long getstage_id() {return stage_id;}
    public void setId(Long stage_id) {this.stage_id = stage_id;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getObjective() {return objective;}
    public void setObjective(String objective) {this.objective = objective;}
    public String getEntreprise() {return entreprise;}
    public void setEntreprise(String entreprise) {this.entreprise = entreprise;}

}
