package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    /*List<Reservation> findAllByAnneeUniversitaire(Date dateAu);

    List<Reservation> findByAnneeUniversitaireBetween(Date dFrom , Date dTo);

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire =:anneeUniversitaire")
    List<Chambre> retrieveResercationssByAnneeUniversitaire(@Param("anneeUniversitaire") Date anneeUniversitaire);

     */
}
