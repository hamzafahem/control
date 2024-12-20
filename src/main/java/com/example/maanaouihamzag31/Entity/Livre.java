package com.example.maanaouihamzag31.Entity;

import jakarta.persistence.*;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Double prix;
    @ManyToOne
    private Auteur auteurId;

    public Livre(String titre, Double prix, Auteur auteurId) {
        this.titre = titre;
        this.prix = prix;
        this.auteurId = auteurId;
    }
    public Livre() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Auteur getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Auteur auteurId) {
        this.auteurId = auteurId;
    }
}
