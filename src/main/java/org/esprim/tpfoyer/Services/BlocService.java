package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Bloc;

import java.util.List;

public interface BlocService {
    public List<Bloc> retriveAllBloc();
    public  Bloc retriveBloc(Long blocId);
    public  Bloc addBloc(Bloc b);
    public  void removeBloc(Long blocId);
    public  Bloc modifyBloc(Bloc bloc);

    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) ;

}
