package org.esprim.tpfoyer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    String nomBloc;
    long capaciteBloc;

    @ManyToOne
    private Foyer foyer;

    /*fetch = FetchType.EAGER
    * quand il va récupérer un bloc il va récupérer liste mte3 les chambres eli fel bloc lkol
    * Fel LAZY 3aks EAGER chye5dem selon el besoin démandé */
    @OneToMany(mappedBy = "bloc",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Chambre> chambres;

}

