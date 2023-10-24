package tn.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation ;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire ;

    private boolean estValide ;

    @ManyToMany( cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

}
