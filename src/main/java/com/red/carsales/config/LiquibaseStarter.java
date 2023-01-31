package com.red.carsales.config;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class LiquibaseStarter {

    @Autowired
    private DataSource dataSource;

    public void startLiquibase() throws LiquibaseException, SQLException {
        java.sql.Connection connection = dataSource.getConnection();

        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        String changeLogPath = "db/changelog/changelog-master.yaml";
        try (Liquibase liquibase = new liquibase.Liquibase(changeLogPath, new ClassLoaderResourceAccessor(), database)) {
            liquibase.update(new Contexts(), new LabelExpression());
        }
    }

}
