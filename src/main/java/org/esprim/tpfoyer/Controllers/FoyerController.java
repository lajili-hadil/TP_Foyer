package org.esprim.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.Entity.Foyer;
import org.esprim.tpfoyer.Services.FoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {

    FoyerService foyerService;

    // http://localhost:/tpfoyer/foyer/retrieve-all-foyers
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        return foyerService.retriveAllFoyer();
    }

    // http://localhost:/tpfoyer/foyer/retrieve-foyer/1
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.retriveFoyer(foyerId);
    }

    // http://localhost:/tpfoyer/foyer/add-foyer
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }

    // http://localhost:/tpfoyer/foyer/remove-foyer/1
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }

    // http://localhost:/tpfoyer/foyer/modify-foyer
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        return foyerService.modifyFoyer(f);
    }

    // http://localhost:/tpfoyer/foyer/ajouter-foyer-et-affecter-a-universite/1
    @PostMapping("/ajouter-foyer-et-affecter-a-universite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable Long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
