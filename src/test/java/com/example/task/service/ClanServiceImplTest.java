package com.example.task.service;

import com.example.task.model.Clan;
import com.example.task.repository.ClanRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@ActiveProfiles({"h2"})
public class ClanServiceImplTest {

    @Autowired
    TaskService taskService;
    @Autowired
    ClanRepositoryImpl repository;

    @Test
    public void test() throws InterruptedException {
        int MAX_SIZE = 100;
        ExecutorService exec = Executors.newFixedThreadPool(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            exec.execute(() -> taskService.completeTask(1, 1, 1, 100));
            Thread.sleep(10);
        }
        Thread.sleep(2000);
        Optional<Clan> clanOptional = repository.getClanById(1);
        Assertions.assertEquals(clanOptional.get().getGold(), 11000);
    }

}
