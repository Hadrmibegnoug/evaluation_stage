                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            package com.jeeapp.evaluationstage.model;

import jakarta.persistence.*;

import java.util.List;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            @Entity
public class Periode {
    @EmbeddedId
    private PeriodeId periodeId;
    @ManyToOne
    private Stagiaire stagiaire;
    @ManyToOne
    private Stage stage;
    @OneToMany(mappedBy = "periode")
    private List<Appreciation> appreciations;
    private String dateDebut;
    private String dateFin;

    public Periode() {super();}
    public Periode(PeriodeId periodeId, String dateDebut, String dateFin) {
        super();
        this.periodeId = periodeId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    public PeriodeId getId() {return periodeId;}
    public void setId(PeriodeId id) {this.periodeId = id;}
    public String getDateDebut() {return dateDebut;}
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }
    public String getDateFin() {return dateFin;}
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
}
