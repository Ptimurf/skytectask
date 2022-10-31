package com.example.task.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPass;

    @Bean
    public BasicDataSource mysqlDataSource() {
        BasicDataSource  dataSource = new BasicDataSource ();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPass);
        dataSource.setInitialSize(100);
        dataSource.setMinIdle(100);
        dataSource.setMaxIdle(30);
        dataSource.setMaxTotal(30);
        dataSource.setMaxOpenPreparedStatements(100);
        return dataSource;
    }
}
