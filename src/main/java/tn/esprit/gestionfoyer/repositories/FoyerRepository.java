package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByNomFoyer(String nom );

    /*List<Foyer> findFoyerByCapaciteFoyer(long capaciteFoyer);

    Foyer findFoyerByNomFoyer(String nom);
    @Query("SELECT f FROM Foyer f WHERE f.capaciteFoyer =:capaciteFoyer")
    List<Chambre> retrieveFoyersByCapacite(@Param("capaciteFoyer") long capaciteFoyer);*/
}
