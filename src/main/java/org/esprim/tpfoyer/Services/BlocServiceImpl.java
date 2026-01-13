package org.esprim.tpfoyer.Services;

import lombok.extern.slf4j.Slf4j;
import org.esprim.tpfoyer.Entity.Bloc;
import org.esprim.tpfoyer.Entity.Chambre;
import org.esprim.tpfoyer.Repository.BlocRepository;
import org.esprim.tpfoyer.Repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.*;
@Slf4j

@Service
public class BlocServiceImpl implements BlocService {
    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retriveAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retriveBloc(Long blocId) {
        return blocRepository.findById(blocId)
                .orElseThrow(() -> new RuntimeException("Bloc not found with id: " + blocId));
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if (bloc != null) {
            for (Long numCh : numChambre) {
                Chambre chambre = chambreRepository.findById(numCh).orElse(null);
                if (chambre != null) {
                    chambre.setBloc(bloc);
                    chambreRepository.save(chambre);
                }
            }
            return bloc;
        }
        return null;
    }
    @Scheduled(cron = "0 */1 * * * *") // Every 1 minute
    public void afficherChambresParBlocEtType() {

        List<Chambre> chambres = chambreRepository.findAll();

        if (chambres.isEmpty()) {
            log.info("Aucune chambre en base.");
            return;
        }

        Map<String, Map<String, Integer>> map = new HashMap<>();

        for (Chambre chambre : chambres) {

            String blocName = (chambre.getBloc() != null) ? chambre.getBloc().getNomBloc() : "NON AFFECTÉ";
            String type = (chambre.getTypeC() != null) ? chambre.getTypeC().toString() : "TYPE NON DEFINI";

            map.putIfAbsent(blocName, new HashMap<>());
            Map<String, Integer> typeCount = map.get(blocName);

            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        log.info(" Statistiques des chambres par Bloc:");

        map.forEach((bloc, types) -> {
            log.info("Bloc: " + bloc);
            types.forEach((type, count) -> log.info(" → " + type + ": " + count));
        });
    }


}
