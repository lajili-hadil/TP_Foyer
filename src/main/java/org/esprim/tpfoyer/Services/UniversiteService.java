package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Universite;

import java.util.List;

public interface UniversiteService {
    public List<Universite> retriveAllUniversite();
    public Universite retriveUniversite(Long universiteId);
    public Universite addUniversite(Universite u);
    public void removeUniversite(Long universiteId);
    public Universite modifyUniversite(Universite universite);

    Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite(Long idUniversite);
}
