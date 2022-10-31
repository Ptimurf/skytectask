package com.example.task.service;

import com.example.task.repository.ClanRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
@Primary
public class ClanServiceImpl implements ClanService {

    @Autowired
    private final ClanRepositoryImpl repository;

    @Override
    public void addGoldToClan(long userId, long clanId, int addingGold) {
        repository.addGoldToClan(userId, clanId, addingGold);
    }
}
