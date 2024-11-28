package org.alejandra.UT02_Manejo_Conectores.ejercicios.ejercicios04;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

public class SakilaConnectionPool {

    @Getter
    private static SakilaConnectionPool instance = new SakilaConnectionPool();
    private static final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/sakila";
    private static final String user = "sakilauser";
    private static final String password = "pwdsakilauser";

    private HikariDataSource dataSource;

    private SakilaConnectionPool() {

       HikariConfig config = new HikariConfig();
        config.setJdbcUrl(CONNECTION_STRING);
        config.setUsername(user);
        config.setPassword(password);

        dataSource = new HikariDataSource(config);
    }

    public static SakilaConnectionPool getInstance() {
        return instance.getInstance();

    }


    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();

    }






}
