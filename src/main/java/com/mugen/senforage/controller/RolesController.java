package com.mugen.senforage.controller;


import com.mugen.senforage.dto.Roles;
import com.mugen.senforage.service.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RolesController {

    private RolesService rolesService;

    @GetMapping
    public List<Roles> getRoles() {return rolesService.getRoles();}

    @GetMapping("/{id}")
    public Roles getRole(@PathVariable("id") int id) {
        return rolesService.getRole(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Roles createRoles(@Valid @RequestBody Roles roles) {
        return rolesService.createRoles(roles);
    }

    @PutMapping("/{id}")
    public Roles updateRoles(@PathVariable("id") int id, @Valid @RequestBody Roles roles) {
        return rolesService.updateRole(id, roles);
    }

    @DeleteMapping("/{id}")
    public void deleteRoles(@PathVariable("id") int id) {rolesService.deleteRole(id);}


}
