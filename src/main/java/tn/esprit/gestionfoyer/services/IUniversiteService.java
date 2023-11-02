package tn.esprit.gestionfoyer.services;
import tn.esprit.gestionfoyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long idUniversite);
    public Universite addUniversite(Universite c);
    public void removeUniversite(Long idUniversite);
    public Universite modifyUniversite(Universite universite);


}
