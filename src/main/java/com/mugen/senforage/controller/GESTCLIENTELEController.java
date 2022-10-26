package com.mugen.senforage.controller;

import com.mugen.senforage.dto.GESTCLIENTELE;
import com.mugen.senforage.service.FactureService;
import com.mugen.senforage.service.GESTCLIENTELEService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gestclient")
@AllArgsConstructor
public class GESTCLIENTELEController {

    private GESTCLIENTELEService gestclienteleService;

    @GetMapping
    public List<GESTCLIENTELE> getGESTCLIENTELES() {return gestclienteleService.getGestClienteles();}

    @GetMapping("/{id}")
    public GESTCLIENTELE getGESTCLIENTELE(@PathVariable("id") int id) {
        return gestclienteleService.getGestClientele(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public GESTCLIENTELE createGESTCLIENTELE(@Valid @RequestBody GESTCLIENTELE gestclientele) {
        return gestclienteleService.createGestClientele(gestclientele);
    }

    @PutMapping("/{id}")
    public GESTCLIENTELE updateGESTCLIENTELE(@PathVariable("id") int id, @Valid @RequestBody GESTCLIENTELE gestclientele) {
        return gestclienteleService.updateGestClientele(id, gestclientele);
    }

    @DeleteMapping("/{id}")
    public void deleteGESTCLIENTELE(@PathVariable("id") int id) {gestclienteleService.deleteGestClientele(id);}


}
