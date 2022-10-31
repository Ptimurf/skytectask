package com.example.task.repository;

import com.example.task.model.Clan;

import java.sql.SQLException;
import java.util.Optional;

public interface ClanRepository {
    void addGoldToClan(long userId, long clanId, int addingGold) throws SQLException;
    Optional<Clan> getClanById(long clanId);
}
