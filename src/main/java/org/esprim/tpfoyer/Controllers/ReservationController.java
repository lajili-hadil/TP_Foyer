package org.esprim.tpfoyer.Controllers;

import org.esprim.tpfoyer.Entity.Reservation;
import org.esprim.tpfoyer.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping("/ajouter-reservation/{id-chambre}/{cin-etudiant}")
    public Reservation ajouterReservation(
            @PathVariable("id-chambre") Long idChambre,
            @PathVariable("cin-etudiant") Long cinEtudiant) {
        return reservationService.ajouterReservation(idChambre, cinEtudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.removeReservation(id);
    }


    @GetMapping("/get-reservations-by-annee-and-universite/{nom-universite}")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @RequestParam("annee") @DateTimeFormat(pattern = "yyyy-MM-dd") Date anneeUniversite,
            @PathVariable("nom-universite") String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }
}
