package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.repositories.BlocRepository;
import tn.esprit.gestionfoyer.repositories.ChambreRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{

    BlocRepository blocRepository ;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }


    ChambreRepository chambreRepository ;

    @Override
    public Bloc affecterChambreABloc(List<Long> numChambre , long idBloc)
    {
        Bloc bloc = blocRepository.findById(idBloc).get();
        List<Chambre> chambres = (List<Chambre>) chambreRepository.findAllById(numChambre);
        for(Chambre chambre : chambres)
        {
            chambre.setBloc(bloc);
            blocRepository.save(bloc);
        }
        return bloc ;
    }
}
