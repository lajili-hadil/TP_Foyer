package org.esprim.tpfoyer.Controllers;


import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.Entity.Chambre;
import org.esprim.tpfoyer.Entity.TypeChambre;
import org.esprim.tpfoyer.Services.ChambreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
//ce classe autowired avec controlleur
public class ChambreController {
    ChambreService chambreService;
    // http://localhost:/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retriveAllChambre();
        return listChambres;
    }
    // http://localhost:/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retriveChambre(chId);
        return chambre;
    }
    // http://localhost:/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    // http://localhost:/tpfoyer/chambre/par-universite/{nomUniversite}
    @GetMapping("/par-universite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }
    @GetMapping("/get-chambres-non-reserve/{nom-universite}/{type}")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @PathVariable("nom-universite") String nomUniversite,
            @PathVariable("type") TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }
}

