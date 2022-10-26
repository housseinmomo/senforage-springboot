package com.mugen.senforage.controller;

import com.mugen.senforage.dto.GESTCOMMERCIALE;
import com.mugen.senforage.service.GESTCOMMERCIALEService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gestcommerciale")
@AllArgsConstructor
public class GESTCOMMERCIALEController {

    private GESTCOMMERCIALEService gestcommercialeService;

    @GetMapping
    public List<GESTCOMMERCIALE> getGESTCOMMERCIALES() {return gestcommercialeService.getGestCommerciales();}

    @GetMapping("/{id}")
    public GESTCOMMERCIALE getGESTCOMMERCIALE(@PathVariable("id") int id) {
        return gestcommercialeService.getGestCommerciale(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public GESTCOMMERCIALE createGESTCOMMERCIALE(@Valid @RequestBody GESTCOMMERCIALE gestcommerciale) {
        return gestcommercialeService.createGestCommerciale(gestcommerciale);
    }

    @PutMapping("/{id}")
    public GESTCOMMERCIALE updateGESTCOMMERCIALE(@PathVariable("id") int id, @Valid @RequestBody GESTCOMMERCIALE gestcommerciale) {
        return gestcommercialeService.updateGestCommerciale(id, gestcommerciale);
    }

    @DeleteMapping("/{id}")
    public void deleteGESTCOMMERCIALE(@PathVariable("id") int id) {gestcommercialeService.deleteGestCommerciale(id);}


}
