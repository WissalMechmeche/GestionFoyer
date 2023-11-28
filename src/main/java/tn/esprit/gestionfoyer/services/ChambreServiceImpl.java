package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.repositories.BlocRepository;
import tn.esprit.gestionfoyer.repositories.ChambreRepository;

import java.util.List;
import java.util.Set;
@Slf4j
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{

    ChambreRepository chambreRepository ;

    BlocRepository blocRepository ;
    //Scheduled(fixedDelay = 10000)
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        //log.info("Add Chambre");
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (bloc != null) {
            List<Chambre> chambres = chambreRepository.findAllById(numChambre);

            if (!chambres.isEmpty()) {
                bloc.setChambres((Set<Chambre>) chambres);
                return blocRepository.save(bloc);
            }
        }

        return null;
    }

}
