package com.example.maanaouihamzag31.Dto;

import com.example.maanaouihamzag31.Entity.Auteur;
import jakarta.persistence.ManyToOne;

public class LivreDto {
    private String titre;
    private Double prix;

    private Auteur auteurId;

    public LivreDto(String titre, Double prix, Auteur auteurId) {
        this.titre = titre;
        this.prix = prix;
        this.auteurId = auteurId;
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
