package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.repositories.FoyerRepository;
import tn.esprit.gestionfoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository ;
    UniversiteRepository universiteRepository ;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public Foyer addfoyer(Foyer c) {
        return foyerRepository.save(c);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }


    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer f = foyerRepository.findById(idFoyer).get();
        Universite u = universiteRepository.findByNomUniversite(nomUniversite);
        u.setFoyer(f);
        return universiteRepository.save(u);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        //Foyer f = foyerRepository.findById(idFoyer).get();
        Universite u = universiteRepository.findById(idUniversite).get();
        return u;
    }
}
