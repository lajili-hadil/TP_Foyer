package org.esprim.tpfoyer.Services;

import org.esprim.tpfoyer.Entity.Reservation;

import java.util.List;

public interface ReservationService {

    public List<Reservation> retriveAllReservation();
    public Reservation retriveReservation(Long reservationId);
    public Reservation addReservation(Reservation reservation);
    public void removeReservation(Long reservationId);
    public Reservation modifyReservation(Reservation reservation);

    public Reservation ajouterReservation(long idChambre, long cinEtudiant);


}
