package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long idBloc);
    public Bloc addBloc(Bloc c);
    public void removeBloc(Long idBloc);
    public Bloc modifyBloc(Bloc bloc);
}
