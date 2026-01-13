package org.esprim.tpfoyer.Repository;

import org.esprim.tpfoyer.Entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findAllByNumeroChambreIn(List<Long> numeroChambres);


   /* @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite")*/
   @Query("SELECT c FROM Chambre c " +
           "WHERE c.bloc.foyer.universite.nomUniversite = :nom")
   List<Chambre> getChambresParNomUniversite(@Param("nom") String nomUniversite);

   // List<Chambre> getChambresParNomUniversite(@Param("nomUniversite") String nomUniversite);

}
