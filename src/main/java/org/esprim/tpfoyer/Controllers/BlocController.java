package org.esprim.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.Entity.Bloc;
import org.esprim.tpfoyer.Services.BlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {

    BlocService blocService;

    // http://localhost:/tpfoyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retriveAllBloc();
        return listBlocs;
    }

    // http://localhost:/tpfoyer/bloc/retrieve-bloc/1
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        Bloc bloc = blocService.retriveBloc(blocId);
        return bloc;
    }

    // http://localhost:/tpfoyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    // http://localhost:/tpfoyer/bloc/remove-bloc/1
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    // http://localhost:/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.modifyBloc(b);
        return bloc;
    }

    // http://localhost:/tpfoyer/bloc/affecter-chambres-a-bloc/1
    @PutMapping("/affecter-chambres-a-bloc/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambres, @PathVariable Long idBloc) {
        return blocService.affecterChambresABloc(numChambres, idBloc);
    }
}
