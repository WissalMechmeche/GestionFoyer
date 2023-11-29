package tn.esprit.gestionfoyer.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.services.IBlocService;

import java.util.List;
@Tag(name = "Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    IBlocService blocService ;


    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }


    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        Bloc bloc = blocService.retrieveBloc(blocId);
        return bloc;
    }


    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc c) {
        Bloc bloc = blocService.addBloc(c);
        return bloc;
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }


    @PutMapping("/modify-chambre")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        Bloc bloc = blocService.modifyBloc(c);
        return bloc;
    }


    @PostMapping ("/affecter-chambre-bloc")
    public Bloc affecterChambreABloc(@RequestBody List<Long> numChambre, @RequestParam("idBloc") long idBloc) {
        Bloc bloc = blocService.affecterChambreABloc(numChambre,idBloc);
        return bloc;
    }
}
