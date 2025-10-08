package org.esprim.tpfoyer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Reservation implements Serializable {
    @Id
    String idReservation;
    Date anneeUniversitaire;
    boolean estValide;

    @ManyToMany
    private List<Etudiant> etudiants;

}


