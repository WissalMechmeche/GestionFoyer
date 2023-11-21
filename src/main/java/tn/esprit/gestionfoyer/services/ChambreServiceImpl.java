package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.repositories.BlocRepository;
import tn.esprit.gestionfoyer.repositories.ChambreRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{

    ChambreRepository chambreRepository ;

    BlocRepository blocRepository ;
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
