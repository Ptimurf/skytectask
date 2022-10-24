package com.example.task.repository;

import com.example.task.StatementsSql;
import com.example.task.factory.ConnectionFactory;
import com.example.task.model.Clan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class ClanRepositoryImpl implements ClanRepository {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public Optional<Clan> getByClanId(long clanId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(StatementsSql.selectClanById);
            statement.setLong(1, clanId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                return Optional.of(Clan.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .gold(resultSet.getInt("gold"))
                        .build());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
        return Optional.empty();
    }
}
