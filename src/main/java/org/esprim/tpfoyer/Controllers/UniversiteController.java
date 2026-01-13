package org.esprim.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.Entity.Universite;
import org.esprim.tpfoyer.Services.UniversiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {

    UniversiteService universiteService;

    // http://localhost:/tpfoyer/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retriveAllUniversite();
    }

    // http://localhost:/tpfoyer/universite/retrieve-universite/1
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retriveUniversite(universiteId);
    }

    // http://localhost:/tpfoyer/universite/add-universite
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    // http://localhost:/tpfoyer/universite/remove-universite/1
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }

    // http://localhost:/tpfoyer/universite/modify-universite
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        return universiteService.modifyUniversite(u);
    }

    // http://localhost:/tpfoyer/universite/affecter-foyer-a-universite/1/ESPRIT
    @PutMapping("/affecter-foyer-a-universite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    // http://localhost:/tpfoyer/universite/desaffecter-foyer-a-universite/1
    @PutMapping("/desaffecter-foyer-a-universite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
