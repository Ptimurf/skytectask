package com.example.task.repository;

import com.example.task.StatementsSql;
import com.example.task.factory.ConnectionFactory;
import com.example.task.model.Clan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ClanRepositoryImpl implements ClanRepository {

    @Autowired
    private final ConnectionFactory factory;

    @Override
    public void addGoldToClan(long userId, long clanId, int addingGold) {

        try (Connection connection = factory.getConnectionWithAutoCommit();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(String.format(StatementsSql.selectClanByIdForUpdate, clanId))) {

            if (!resultSet.next()) {
                log.info("Клан " + clanId + " не найден");
                return;
            }
            connection.setAutoCommit(false);
            int goldBefore = resultSet.getInt("gold");
            if (goldBefore + addingGold < 0) {
                log.info("Клану " + clanId + " не хватает средств. Надо " + addingGold + " есть " + goldBefore);
                return;
            }
            int goldTotal = goldBefore + addingGold;
            resultSet.updateInt(3, goldTotal);
            resultSet.updateRow();
            log.info("Клан " + clanId + " получил " + addingGold + " от пользователя " + userId + ". Было " + goldBefore + " Стало " + goldTotal);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Optional<Clan> getClanById(long clanId) {
        try (Connection connection = factory.getConnectionWithAutoCommit();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery(String.format(StatementsSql.getClanByIdForRead, clanId))) {
            if (resultSet.next()) {
                return Optional.of(Clan.builder()
                        .name(resultSet.getString("name"))
                        .id(resultSet.getLong("id"))
                        .gold(resultSet.getInt("gold"))
                        .build());
            }
            return Optional.empty();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
