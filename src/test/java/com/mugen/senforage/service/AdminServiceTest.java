package com.mugen.senforage.service;

import com.mugen.senforage.dto.Abonnement;
import com.mugen.senforage.dto.Admin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {


    @Autowired
    private AdminService adminService;

    @Test
    public void getAdmins() {
        List<Admin> AdminsList = adminService.getAdmins();
        Assertions.assertEquals(0, AdminsList.size());
    }


    @Test
    void getAdmin() {
        Admin admin = adminService.getAdmin(1);
        Assertions.assertNotNull(admin);
    }

    @Test
    void createAdmin() {
        Admin admin = new Admin();
        admin.setEmail("smrobla34@gmail.com");
        admin.setNom("mugen");
        admin.setPrenom("katakuri");
        admin.setMdp("malyounhouss@123");
        admin.setEtat(true);
        Admin adminSave = adminService.createAdmin(admin);
        Assertions.assertNotNull(adminSave);
    }

    @Test
    void updateAdmin() {
        Admin admin = new Admin();
        admin.setPrenom("Yukai");
        Admin adminSave = adminService.updateAdmin(1, admin);
        Assertions.assertEquals("Yukai", adminSave.getPrenom());
    }

    @Test
    void deleteAdmin() {
        adminService.deleteAdmin(1);
        Assertions.assertTrue(true);
    }



}
