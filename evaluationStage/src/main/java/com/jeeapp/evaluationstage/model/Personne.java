package com.jeeapp.evaluationstage.model;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String prenom;
    private String email;

    public Personne() {super();}
    public Personne(String nom, String prenom, String email) {this.nom = nom;this.prenom = prenom;this.email = email;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}
