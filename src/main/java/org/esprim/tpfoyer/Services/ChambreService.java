package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Chambre;

import java.util.List;

public interface ChambreService {

    public List<Chambre> retriveAllChambre();
    public  Chambre retriveChambre(Long chambreId);
    public  Chambre addChambre(Chambre c);
    public  void removeChambre(Long chambreId);
    public  Chambre modifyChambre(Chambre chambre);

    public List<Chambre> getChambresParNomUniversite(String nomUniversite);
}
