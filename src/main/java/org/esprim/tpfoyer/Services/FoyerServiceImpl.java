package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Bloc;
import org.esprim.tpfoyer.Entity.Foyer;
import org.esprim.tpfoyer.Entity.Universite;
import org.esprim.tpfoyer.Repository.FoyerRepository;
import org.esprim.tpfoyer.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements FoyerService {
    @Autowired
    private FoyerRepository foyerRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public List<Foyer> retriveAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retriveFoyer(Long id) {
        return foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer not found with id: " + id));
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer modifyFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université not found with id: " + idUniversite));

        if (universite.getFoyer() != null) {
            throw new RuntimeException("Cette université a déjà un foyer affecté");
        }
        for(Bloc bloc : foyer.getBlocs()) {
            bloc.setFoyer(foyer);
        }

        //Assurer la cohérence bloc foyer

        if(foyer.getBlocs() != null)
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));

        /*
        List<Bloc> listBloc = foyer.getBlocs();
        for(Bloc bloc : listBloc) {
            bloc.setFoyer(foyer);
        }*/

        Foyer savedFoyer = foyerRepository.save(foyer);
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);
        return savedFoyer;

    }
}
