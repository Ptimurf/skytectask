package com.example.task.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class ConnectionFactory {

    @Autowired
    private DataSource dataSource;

    @Bean
    @Scope("prototype")
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
