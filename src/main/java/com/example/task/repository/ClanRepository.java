package com.example.task.repository;

import com.example.task.model.Clan;

import java.util.Optional;

public interface ClanRepository {
    Optional<Clan> getByClanId(long clanId);
}
