package com.mugen.senforage.controller;


import com.mugen.senforage.dto.Village;
import com.mugen.senforage.service.VillageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/village")
@AllArgsConstructor
public class VillageController {

    private VillageService villageService;

    @GetMapping
    public List<Village> getVillages() {return villageService.getVillages();}

    @GetMapping("/{id}")
    public Village getVillage(@PathVariable("id") int id) {
        return villageService.getVillage(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Village createVillage(@Valid @RequestBody Village village) {
        return villageService.createVillage(village);
    }

    @PutMapping("/{id}")
    public Village updateVillage(@PathVariable("id") int id, @Valid @RequestBody Village village) {
        return villageService.updateVillage(id, village);
    }

    @DeleteMapping("/{id}")
    public void deleteVillage(@PathVariable("id") int id) {villageService.deleteVillage(id);}

}
