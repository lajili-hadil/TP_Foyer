package org.esprim.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.Entity.Foyer;
import org.esprim.tpfoyer.Entity.Universite;
import org.esprim.tpfoyer.Repository.FoyerRepository;
import org.esprim.tpfoyer.Repository.UniversiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements UniversiteService {
    //@Autowired
    private UniversiteRepository universiteRepository;
    private FoyerRepository foyerRepository;

    @Override
    public List<Universite> retriveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retriveUniversite(Long universiteId) {
        return universiteRepository.findById(universiteId)
                .orElseThrow(() -> new RuntimeException("Université not found with id: " + universiteId));
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found" + idFoyer));

        Universite universite =universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found" + nomUniversite));

        if (foyer.getUniversite()!=null || universite.getFoyer()!=null) {
            throw new RuntimeException("Foyer or Universite already assigned");
        }
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;
    }
    public Universite desaffecterFoyerAUniversite(Long idUniversite) {

        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException
                        ("Université not found : " + idUniversite));
        if (universite.getFoyer() == null) {
            throw new RuntimeException("Aucun foyer  !");
        }

        Foyer foyer = universite.getFoyer();

        universite.setFoyer(null);
        foyer.setUniversite(null);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);

        return universite;
    }}
