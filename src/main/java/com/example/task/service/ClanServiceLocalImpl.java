package com.example.task.service;

import com.example.task.model.Clan;
import com.example.task.repository.ClanRepositoryLocalImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClanServiceLocalImpl implements ClanService{

    @Autowired
    private final ClanRepositoryLocalImpl repository;

    @Override
    public void addGoldToClan(long userId, long clanId, int addetGold) {
        Optional<Clan> clanOptional = repository.getClanById(clanId);
        if(clanOptional.isEmpty())
            log.info("Клан " + clanId + " не найден");
        Clan clan = clanOptional.get();
        synchronized (clan){
            int goldBefore = clan.getGold();
            int goldTotal = goldBefore + addetGold;
            if (goldTotal < 0) {
                log.info("Клану " + clanId + " не хватает средств. Надо " + addetGold + " есть " + goldBefore);
                return;
            }
            clan.setGold(goldTotal);
            log.info("Клан " + clanId + " получил " + addetGold + " от пользователя " + userId + ". Было " + goldBefore + " Стало " + goldTotal);
        }
    }
}
