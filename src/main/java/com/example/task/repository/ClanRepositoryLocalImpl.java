package com.example.task.repository;

import com.example.task.model.Clan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ClanRepositoryLocalImpl implements ClanRepository {

    private static final List<Clan> clanList;

    static {
        clanList = new ArrayList<>(Arrays.asList(Clan.builder().id(1).name("name").gold(1000).build()));
    }

    @Override
    public void addGoldToClan(long userId, long clanId, int addingGold) throws SQLException {
    }

    @Override
    public synchronized Optional<Clan> getClanById(long clanId) {
        for (Clan clan : clanList){
            if (clan.getId()==clanId){
                return Optional.of(clan);
            }
        }
        return Optional.empty();
    }



}
