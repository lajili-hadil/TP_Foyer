package org.esprim.tpfoyer.Controllers;

import org.esprim.tpfoyer.Entity.Reservation;
import org.esprim.tpfoyer.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.retriveAllReservation();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.retriveReservation(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.removeReservation(id);
    }

    /**
     * Ajouter une réservation et l'affecter à une chambre et un étudiant
     * @param idChambre l'ID de la chambre
     * @param cinEtudiant le CIN de l'étudiant
     * @return la réservation créée
     */
    @PostMapping("/ajouter/{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idChambre, @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idChambre, cinEtudiant);
    }
}
