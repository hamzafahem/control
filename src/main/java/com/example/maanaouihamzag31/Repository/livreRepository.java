package com.example.maanaouihamzag31.Repository;

import com.example.maanaouihamzag31.Entity.Auteur;
import com.example.maanaouihamzag31.Entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface livreRepository extends JpaRepository<Livre,Long> {
    List<Livre> findLivreBetwenPrice(Double pr1, Double pr2);


    List<Livre> findLivreByAuteurId(Auteur auteur);
}
