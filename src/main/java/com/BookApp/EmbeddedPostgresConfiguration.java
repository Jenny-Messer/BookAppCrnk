// Copyright (c) 2018 Travelex Ltd

package com.BookApp;

import static java.nio.file.Paths.get;
import static ru.yandex.qatools.embed.postgresql.EmbeddedPostgres.cachedRuntimeConfig;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ru.yandex.qatools.embed.postgresql.PostgresProcess;
import ru.yandex.qatools.embed.postgresql.PostgresStarter;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

@Configuration
public class EmbeddedPostgresConfiguration {

    @Bean(destroyMethod = "stop")
    public PostgresProcess postgresProcess() throws IOException {

        PostgresConfig postgresConfig = new PostgresConfig(Version.V9_6_8,
                                                           new AbstractPostgresConfig.Net("localhost", 5444),
                                                           new AbstractPostgresConfig.Storage("books"),
                                                           new AbstractPostgresConfig.Timeout(),
                                                           new AbstractPostgresConfig.Credentials("postgres", "postgres"));
        return PostgresStarter.getInstance(cachedRuntimeConfig(get("/tmp")))
                              .prepare(postgresConfig)
                              .start();
    }

    @Bean(destroyMethod = "close")
    @DependsOn("postgresProcess")
    public DataSource dataSource(PostgresProcess postgresProcess) {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();

        PostgresConfig postgresConfig = postgresProcess.getConfig();

        dataSource.setUser(postgresConfig.credentials().username());
        dataSource.setPassword(postgresConfig.credentials().password());
        dataSource.setPortNumber(postgresConfig.net().port());
        dataSource.setServerName(postgresConfig.net().host());
        dataSource.setDatabaseName(postgresConfig.storage().dbName());

        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT FROM pg_catalog.pg_user WHERE usename = 'books'")) {
            if (!resultSet.next()) {
                statement.execute("CREATE USER books WITH PASSWORD 'Travelex123'");
                statement.execute("CREATE SCHEMA books AUTHORIZATION books");
            }
        } catch (SQLException e) {
        }

        dataSource = new PGPoolingDataSource();
        dataSource.setUser("books");
        dataSource.setPassword("Travelex123");
        dataSource.setPortNumber(postgresConfig.net().port());
        dataSource.setServerName(postgresConfig.net().host());
        dataSource.setDatabaseName(postgresConfig.storage().dbName());
        return dataSource;
    }
}
