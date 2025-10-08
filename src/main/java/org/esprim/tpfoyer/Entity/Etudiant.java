package org.esprim.tpfoyer.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;

    private String nomEtudiant;
    private String prenomEtudiant;
    private long cinEtudiant;
    private String ecole;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}



