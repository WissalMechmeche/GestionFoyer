package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    /*List<Chambre> findAllByTypeChambre(TypeChambre tc);
    Chambre findChambreByNumeroChambre(long numC);

    @Query("SELECT c FROM Chambre c WHERE c.TypeC =:typeC")
    List<Chambre> retrieveChambresByTypeC(@Param("typeC") String typeC);*/




}
