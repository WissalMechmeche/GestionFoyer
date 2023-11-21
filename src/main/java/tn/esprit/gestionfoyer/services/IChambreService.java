package tn.esprit.gestionfoyer.services;

import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;

import java.util.List;

public interface IChambreService {

    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;


}
