package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Etudiant;
import tn.esprit.gestionfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long idFoyer);
    public Foyer addfoyer(Foyer c);
    public void removeFoyer(Long idFoyer);
    public Foyer modifyFoyer(Foyer foyer);
}
