package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Chambre;
import org.esprim.tpfoyer.Repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retriveAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retriveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);

    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.getChambresParNomUniversite(nomUniversite);
    }
}
