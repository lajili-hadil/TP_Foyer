package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Bloc;
import org.esprim.tpfoyer.Entity.Foyer;

import java.util.List;

public interface FoyerService {
    public List<Foyer> retriveAllFoyer();
    public Foyer retriveFoyer(Long id);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long id);
    public Foyer modifyFoyer(Foyer f);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
   }
