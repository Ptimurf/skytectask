package com.example.task.repository;

import com.example.task.factory.ConnectionFactory;
import com.example.task.model.Clan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles({"h2"})
public class ClanRepositoryTest {

    @Autowired
    ConnectionFactory connectionFactory;

    @Autowired
    ClanRepositoryImpl clanRepository;

    @Test
    public void getByClanIdTestSuccess() {
        Optional<Clan> clanOptional;
        clanOptional = clanRepository.getClanById(1);
        assertTrue(clanOptional.isPresent());
        assertEquals("clan1", clanOptional.get().getName());


    }

    @Test
    public void getByClanIdTestFailed() {
        Optional<Clan> clanOptional;
        clanOptional = clanRepository.getClanById(2);
        assertFalse(clanOptional.isPresent());


    }

}
