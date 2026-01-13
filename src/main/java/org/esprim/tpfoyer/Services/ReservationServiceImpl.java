package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Chambre;
import org.esprim.tpfoyer.Entity.Etudiant;
import org.esprim.tpfoyer.Entity.Reservation;
import org.esprim.tpfoyer.Entity.TypeChambre;
import org.esprim.tpfoyer.Repository.ChambreRepository;
import org.esprim.tpfoyer.Repository.EtudiantRepository;
import org.esprim.tpfoyer.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retriveAllReservation() {
        return List.of();
    }

    @Override
    public Reservation retriveReservation(Long reservationId) {
        return null;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void removeReservation(Long reservationId) {

    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        return null;
    }
    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        // Using JPQL query from repository
        return reservationRepository.findReservationsByAnneeAndUniversite(anneeUniversite, nomUniversite);
    }

    private int getMaxCapacity(TypeChambre type) {
        switch (type) {
            case SIMPLE:
                return 1;
            case DOUBLE:
                return 2;
            case TRIPLE:
                return 3;
            default:
                return 0;
        }
    }

}
