package com.mugen.senforage.service;

import com.mugen.senforage.dto.Admin;
import com.mugen.senforage.dto.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {


    @Autowired
    private ClientService clientService;

    @Test
    public void getClients() {
        List<Client> ClientsList = clientService.getClients();
        Assertions.assertEquals(0, ClientsList.size());
    }


    @Test
    void getClient() {
        Client client = clientService.getClient(1);
        Assertions.assertNotNull(client);
    }

    @Test
    void createClient() {
        Client client = new Client();
        client.setAdresse("Djibouti");
        client.setNomFamille("Fugen");
        client.setTelephone(88123834);

        Client clientSave = clientService.createClient(client);
        Assertions.assertNotNull(clientSave);
    }

    @Test
    void updateClient() {
        Client client = new Client();
        client.setNomFamille("Yukai");
        Client clientSave = clientService.updateClient(1, client);
        Assertions.assertEquals("Yukai", clientSave.getNomFamille());
    }

    @Test
    void deleteClient() {
        clientService.deleteClient(1);
        Assertions.assertTrue(true);
    }
}
