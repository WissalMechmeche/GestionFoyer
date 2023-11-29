package tn.esprit.gestionfoyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.repositories.FoyerRepository;
import tn.esprit.gestionfoyer.repositories.UniversiteRepository;

import java.util.List;
@Slf4j
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
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        if (f != null) {
            Universite u = f.getUniversite();

            if (u != null) {
                u.setFoyer(null);
                universiteRepository.save(u);
            }

            return u;
        }
        return null;
    }


    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer , long idUniversite)
    {
        Foyer foyer1 = foyerRepository.save(foyer);
        Universite universite = universiteRepository.findById(idUniversite).get();
        universite.setFoyer(foyer1);
        universiteRepository.save(universite);
        return foyer1;
    }
}
