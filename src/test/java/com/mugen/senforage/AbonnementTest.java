package com.mugen.senforage;

import com.mugen.senforage.dao.IAbonnementRepository;
import com.mugen.senforage.dto.Abonnement;
import com.mugen.senforage.mapping.AbonnementMapper;
import com.mugen.senforage.service.AbonnementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AbonnementTest {



    @Test
    void getAbonnements() {
        Assertions.assertEquals(4, 2 + 2);
    }
}
