package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Etudiant;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.repositories.ChambreRepository;
import tn.esprit.gestionfoyer.repositories.EtudiantRepository;
import tn.esprit.gestionfoyer.repositories.ReservationRepository;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{

    ReservationRepository reservationRepository ;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public Reservation addReservation(Reservation c) {
        return reservationRepository.save(c);
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);

    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    ChambreRepository chambreRepository ;
    EtudiantRepository etudiantRepository;
    @Override
    public Reservation ajouterReservation(long idChambre, long  cinEtudiant) {

    }
}
