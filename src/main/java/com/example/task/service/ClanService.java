package com.example.task.service;
import com.example.task.model.Clan;

public interface ClanService {
    void addGoldToClan(long userId, long clanId, int gold);
}
