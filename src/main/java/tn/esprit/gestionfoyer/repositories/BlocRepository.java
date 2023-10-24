package tn.esprit.gestionfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Chambre;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {

    /*Bloc findBlocsByNomBloc(String nomBloc);
    List<Bloc> findBlocsByCapaciteBloc(long capaciteBloc);

    @Query("SELECT b FROM Bloc b WHERE b.capaciteBloc =:capaciteBloc")
    List<Chambre> retrieveBlocsByCapacite(@Param("capaciteBloc") long capaciteBloc);*/

}
