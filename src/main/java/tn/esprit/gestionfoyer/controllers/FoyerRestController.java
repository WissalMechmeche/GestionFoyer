package tn.esprit.gestionfoyer.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.services.IFoyerService;

import java.util.List;
@Tag(name = "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

    @Autowired
    IFoyerService foyerService ;

    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.retrieveAllFoyers();
        return listFoyers;
    }


    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveBloc(@PathVariable("foyer-id") Long foyerId) {
        Foyer foyer = foyerService.retrieveFoyer(foyerId);
        return foyer;
    }


    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.addfoyer(c);
        return foyer;
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }


    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.modifyFoyer(c);
        return foyer;
    }

    @PutMapping("/affecter-Foyer-A-Universite")
    public Universite affecterFoyerAUniversite(@RequestParam long idFoyer , @RequestParam String nomUniversite) {
        return foyerService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

    @PutMapping("/affecter-Foyer-A-Universite/{idFoyer}/{nomUniversite}")
    public void affecterFoyerAUni(@PathVariable("idFoyer") long idFoyer , @PathVariable("nomUniversite")
    String nomUniversite) {
        foyerService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping ("/desaffecter-Foyer-A-Universite")
    public void desaffecterFoyerDUniversite(@RequestParam long idFoyer, @RequestParam long idUniv) {
        foyerService.desaffecterFoyerAUniversite(idFoyer,idUniv);
    }





}
