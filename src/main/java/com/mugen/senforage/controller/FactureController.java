package com.mugen.senforage.controller;

import com.mugen.senforage.dto.Facture;
import com.mugen.senforage.service.CompteurService;
import com.mugen.senforage.service.FactureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facture")
@AllArgsConstructor
public class FactureController {

    private FactureService factureService;

    @GetMapping
    public List<Facture> getFactures() {return factureService.getFactures();}

    @GetMapping("/{id}")
    public Facture getFacture(@PathVariable("id") int id) {
        return factureService.getFacture(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Facture createFacture(@Valid @RequestBody Facture facture) {
        return factureService.createFacture(facture);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable("id") int id, @Valid @RequestBody Facture facture) {
        return factureService.updateFacture(id, facture);
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable("id") int id) {factureService.deleteFacture(id);}


}
