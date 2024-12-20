package com.example.maanaouihamzag31.Controller;

import com.example.maanaouihamzag31.Dto.LivreDto;
import com.example.maanaouihamzag31.Entity.Auteur;
import com.example.maanaouihamzag31.Entity.Livre;
import com.example.maanaouihamzag31.Repository.AuteurRepository;
import com.example.maanaouihamzag31.Repository.livreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class LivreControllerGraphQL {
    @Autowired
    private AuteurRepository auteurRepository;

    @Autowired
    private livreRepository livreRepository;
     @QueryMapping
    public List<Livre>  GetLivreAll(){
        return livreRepository.findAll();
    }
    @QueryMapping
    public Optional<Livre> GetLivreById(@Argument Long id){
         return livreRepository.findById(id);
    }
    @QueryMapping
    public List<Livre> GetLivreAllBetwenPrice(@Argument Double pr1 ,@Argument Double pr2){
         return livreRepository.findLivreBetwenPrice(pr1, pr2);
    }
    @QueryMapping
    public List<Livre> GetLivreParAuteur(Auteur auteur){
         return  livreRepository.findLivreByAuteurId(auteur);
    }
    @QueryMapping
    public List<Auteur> GetAuteurALL(){
         return auteurRepository.findAll();
    }



    /////////////////////////////////////////////////////////////////////
    @MutationMapping
    public String Ajouterlivre(@Argument LivreDto livreTosave){
        if (livreTosave != null) {
            if (livreTosave.getAuteurId().getLivres().isEmpty()) {
                System.out.println("probleme");
                return "Auteur has no books.";
            } else {
                Auteur auteur = livreTosave.getAuteurId(); // Assign the Auteur directly
                Livre livre = new Livre();
                livre.setTitre(livreTosave.getTitre());
                livre.setPrix(livreTosave.getPrix());
                livre.setAuteurId(auteur); // Set the Auteur reference to the Livre

                livreRepository.save(livre); // Save the Livre to the database
                return "Bien ajouté";
            }
        }
        return "Invalid input";
    }

    @MutationMapping
    public Boolean MiseAjour(@Argument Long id, @Argument LivreDto livreTosave){
        Optional<Livre> livreOptional = livreRepository.findById(id);
        if (livreOptional.isPresent() && livreTosave != null) {
            Livre livre = livreOptional.get();
            livre.setTitre(livreTosave.getTitre());
            livre.setPrix(livreTosave.getPrix());
            livre.setAuteurId(livreTosave.getAuteurId()); // Update the Auteur

            livreRepository.save(livre); // Save the updated Livre
            return true;
        }
        return false;
    }

    @MutationMapping
    public Boolean Delete(@Argument Long id){
        Optional<Livre> livreOptional = livreRepository.findById(id);
        if (livreOptional.isPresent()) {
            livreRepository.deleteById(id); // Delete the Livre by ID
            return true;
        }
        return false;
    }}




