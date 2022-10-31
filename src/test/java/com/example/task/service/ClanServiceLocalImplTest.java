package com.example.task.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@ActiveProfiles({"h2"})
public class ClanServiceLocalImplTest {

    @Autowired
    ClanServiceLocalImpl service;

    @Test
    public void test() throws InterruptedException {
        int MAX_SIZE = 100;
        ExecutorService exec = Executors.newFixedThreadPool(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            exec.execute(() -> service.addGoldToClan(1, 1, 100));
            Thread.sleep(10);
        }
        Thread.sleep(2000);
    }

}
