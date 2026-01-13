package org.esprim.tpfoyer.Services;

import com.sun.source.tree.NewArrayTree;
import org.esprim.tpfoyer.Entity.Bloc;
import org.esprim.tpfoyer.Entity.Chambre;
import org.esprim.tpfoyer.Repository.BlocRepository;
import org.esprim.tpfoyer.Repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

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
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() ->new RuntimeException("bloc intovable:"+idBloc));

        List<Chambre> chambres =  chambreRepository.findAllByNumeroChambreIn(numChambres);
        if (chambres.size() != numChambres.size()) {
            throw  new RuntimeException("une ou plusieurs"+"chambre sont introuvable");
        }
        for (Chambre chambre : chambres)
            if (chambre.getBloc() != null && chambre.getBloc().getIdBloc()!=idBloc){
                throw  new RuntimeException("chambre "+chambre.getNumeroChambre()+" est deja affecte a un  autre bloc");
            }
        for (Chambre chambre : chambres){
            chambre.setBloc(bloc);
        }
        if(bloc.getChambres() ==null)
            bloc.setChambres((List<Chambre>) new ArrayList<Chambre>());

        bloc.getChambres().addAll(chambres);
        blocRepository.save(bloc);
        chambreRepository.saveAll(chambres);
        return bloc;
    }



}
