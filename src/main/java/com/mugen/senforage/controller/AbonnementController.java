package com.mugen.senforage.controller;

import com.mugen.senforage.service.AbonnementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.mugen.senforage.dto.Abonnement;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abonnement")
@AllArgsConstructor
public class AbonnementController {

    private AbonnementService abonnementService;

    @GetMapping
    public List<Abonnement> getAbonnements() {
        return abonnementService.getAbonnments();
    }

    @GetMapping("/{id}")
    public Abonnement getAbonnement(@PathVariable("id") int id) {
        return abonnementService.getAbonnment(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Abonnement createAbonnement(@Valid @RequestBody Abonnement abonnement) {
        return abonnementService.createAbonnement(abonnement);
    }

    @PutMapping("/{id}")
    public Abonnement updateAbonnement(@PathVariable("id") int id, @Valid @RequestBody Abonnement abonnement) {
        return abonnementService.updateAbonnement(id, abonnement);
    }

    @DeleteMapping("/{id}")
    public void deleteAbonnement(@PathVariable("id") int id) {
        abonnementService.deleteAbonnement(id);
    }
}
