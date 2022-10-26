package com.mugen.senforage.controller;


import com.mugen.senforage.dto.GESTCOMPTEUR;
import com.mugen.senforage.service.GESTCOMPTEURService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gestcompteur")
@AllArgsConstructor
public class GESTCOMPTEURController {

    private GESTCOMPTEURService gestcompteurService;

    @GetMapping
    public List<GESTCOMPTEUR> getGESTCOMPTEURS() {return gestcompteurService.getGestCompteurs();}

    @GetMapping("/{id}")
    public GESTCOMPTEUR getGESTCOMPTEUR(@PathVariable("id") int id) {
        return gestcompteurService.getGestCompteur(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public GESTCOMPTEUR createGESTCOMPTEUR(@Valid @RequestBody GESTCOMPTEUR gestcompteur) {
        return gestcompteurService.createGestCompteur(gestcompteur);
    }

    @PutMapping("/{id}")
    public GESTCOMPTEUR updateGESTCOMPTEUR(@PathVariable("id") int id, @Valid @RequestBody GESTCOMPTEUR gestcompteur) {
        return gestcompteurService.updateGestCompteur(id, gestcompteur);
    }

    @DeleteMapping("/{id}")
    public void deleteGESTCOMPTEUR(@PathVariable("id") int id) {gestcompteurService.deleteGestCompteur(id);}



}
