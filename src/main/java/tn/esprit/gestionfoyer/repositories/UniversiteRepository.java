package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Universite;

import java.util.Date;
import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {

    /*List<Universite> findUniversiteByAdresse(String adresse);

    Universite findUniversiteByNomUniversite(String nom);
    @Query("SELECT u FROM Universite u WHERE u.adresse =:adresse")
    List<Chambre> retrieveUniversitesByAdresse(@Param("adresse") String adresse);*/
}
