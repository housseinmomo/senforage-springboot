package com.mugen.senforage.controller;

import com.mugen.senforage.dto.Admin;
import com.mugen.senforage.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;

    @GetMapping
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable("id") int id) {
        return adminService.getAdmin(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable("id") int id, @Valid @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable("id") int id) {adminService.deleteAdmin(id);}
}
