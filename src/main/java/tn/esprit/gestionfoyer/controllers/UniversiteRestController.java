package tn.esprit.gestionfoyer.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Reservation;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.services.IUniversiteService;

import java.util.List;
@Tag(name = "Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    @Autowired
    IUniversiteService universiteService ;

    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        return listUniversites;
    }


    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        Universite universite = universiteService.retrieveUniversite(universiteId);
        return universite;
    }


    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite c) {
        Universite universite = universiteService.addUniversite(c);
        return universite;
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }


    @PutMapping("/modify-universite")
    public Universite modifyuniversite(@RequestBody Universite c) {
        Universite universite = universiteService.modifyUniversite(c);
        return universite;
    }
}
