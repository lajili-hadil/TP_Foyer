package org.esprim.tpfoyer.Controllers;

import org.esprim.tpfoyer.Entity.Etudiant;
import org.esprim.tpfoyer.Services.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EtudiantController {

    private EtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/retrieve-etudiant/{id-etudiant}")
    public Etudiant retrieveEtudiant(@PathVariable("id-etudiant") Long idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }

    @PostMapping("/add-etudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/remove-etudiant/{id-etudiant}")
    public void removeEtudiant(@PathVariable("id-etudiant") Long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}
