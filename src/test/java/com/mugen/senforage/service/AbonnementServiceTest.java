package com.mugen.senforage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import com.mugen.senforage.dto.Abonnement;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class AbonnementServiceTest {


    private AbonnementService abonnementService;

    public AbonnementServiceTest(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @Test
    public void getAbonnements() {
        List<Abonnement> AbonnementList = abonnementService.getAbonnments();
        Assertions.assertEquals(0, AbonnementList.size());
    }


    @Test
    void getAbonnement() {
        Abonnement abonnement = abonnementService.getAbonnment(1);
        Assertions.assertNotNull(abonnement);
    }

    @Test
    void createAppRoles() {
        Abonnement abonnement = new Abonnement();
        abonnement.setDateAbonnement(new Date());
        abonnement.setDescription("Abonnement premium");
        Abonnement abonnementSave = abonnementService.createAbonnement(abonnement);
        Assertions.assertNotNull(abonnementSave);
    }

    @Test
    void updateAbonnement() {
        Abonnement abonnement = new Abonnement();
        abonnement.setDescription("Abonnement premium Extra");
        Abonnement abonnementSave = abonnementService.updateAbonnement(1, abonnement);
        Assertions.assertEquals("Abonnement premium Extra", abonnementSave.getDescription());
    }

    @Test
    void deleteAppRoles() {
        abonnementService.deleteAbonnement(2);
        Assertions.assertTrue(true);
    }

}
