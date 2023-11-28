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
        Reservation r = new Reservation();
        Chambre c = chambreRepository.getById(idChambre);
        Etudiant e = etudiantRepository.findEtudiantByCin(cinEtudiant);
        int nbRes = (c.getReservations()).size();
        if (c.getTypeC().equals("SIMPLE")&&(nbRes<1))
        {
            //String numRes = c.getNumeroChambre()+"-"+c.getBloc().getNomBloc()+"-"+cinEtudiant;
            r.setIdReservation(c.getNumeroChambre()-cinEtudiant);
            r.setEstValide(true);
            c.getReservations().add(r);
            e.getReservations().add(r);
        }
        else if (c.getTypeC().equals("DOUBLE")&&(nbRes<2))
        {
            r.setIdReservation(c.getNumeroChambre() - cinEtudiant);
            r.setEstValide(true);
            c.getReservations().add(r);
            e.getReservations().add(r);
        }
        else if (c.getTypeC().equals("TRIPLE")&&(nbRes<3))
        {
            r.setIdReservation(c.getNumeroChambre() - cinEtudiant);
            r.setEstValide(true);
            c.getReservations().add(r);
            e.getReservations().add(r);
        }
        chambreRepository.save(c);
        etudiantRepository.save(e);
        reservationRepository.save(r);
        return r ;
    }
}
