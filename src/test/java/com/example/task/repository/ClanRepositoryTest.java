package com.example.task.repository;

import com.example.task.model.Clan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"h2"})
public class ClanRepositoryTest {

    @Autowired
    ClanRepositoryImpl clanRepository;

    @Test
    public void getByClanIdTestSuccess() {
        Optional<Clan> clanOptional = clanRepository.getByClanId(1);
        assertTrue(clanOptional.isPresent());
        assertEquals("clan1", clanOptional.get().getName());
    }

    @Test
    public void getByClanIdTestFailed() {
        Optional<Clan> clanOptional = clanRepository.getByClanId(2);
        assertFalse(clanOptional.isPresent());
    }

}
