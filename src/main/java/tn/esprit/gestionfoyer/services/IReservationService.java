package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.entities.Universite;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long idReservation);
    public Reservation addReservation(Reservation c);
    public void removeReservation(Long idReservation);
    public Reservation modifyReservation(Reservation reservation);

    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;

}
