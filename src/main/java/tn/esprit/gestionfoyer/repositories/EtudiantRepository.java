package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByCin(long cin);
    /*

    List<Etudiant> findEtudiantByEcole(String ecole);

    @Query("SELECT e FROM Etudiant e WHERE e.cin =:cin")
    List<Etudiant> retrieveEtudiantsByCIN(@Param("cin") long cin);*/

}
