                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            package com.jeeapp.evaluationstagev2.model.entities;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            import jakarta.persistence.*;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            import java.util.List;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            @Entity
public class Periode {
    @EmbeddedId
    private PeriodeId periodeId;
    @ManyToOne
    @MapsId("stagiaireId") // 👈 lie au champ dans la clé composée
    @JoinColumn(name = "stagiaire_id")
    private Stagiaire stagiaire;
    @ManyToOne
    @MapsId("stageId") // 👈 lie au champ dans la clé composée
    @JoinColumn(name = "stage_id")
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
    public Stage getStage() {return stage;}
    public void setStage(Stage stage) {this.stage = stage;}
    public Stagiaire getStagiaire() {return stagiaire;}
    public void setStagiaire(Stagiaire stagiaire) {this.stagiaire = stagiaire;}
}
