package tn.esprit.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEt;

    private String prenomEt;

    private long cin ;

    private String ecole ;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;

    @ManyToMany( mappedBy = "etudiants",cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
