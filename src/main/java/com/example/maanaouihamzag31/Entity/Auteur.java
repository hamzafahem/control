package com.example.maanaouihamzag31.Entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nomA;

   

    @OneToMany(mappedBy = "auteurId")
    private List<Livre> livres;
    public Auteur(String nomA, List<Livre> livres) {
        this.nomA = nomA;
        this.livres = livres;
    }

    public Auteur() {
    }

    public Auteur(Auteur auteurId) {
    }

    public String getNomA() {
        return nomA;
    }

    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
