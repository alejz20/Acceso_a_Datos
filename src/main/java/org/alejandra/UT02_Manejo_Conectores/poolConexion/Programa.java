package org.alejandra.UT02_Manejo_Conectores.poolConexion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Programa {
    private static final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/sakila";
    private static final String user = "sakilauser";
    private static final String password = "pwdsakilauser";

    private static final String SQL_INSERT = "update customer set first_name = ?  where customer_id = 1";

    public static void main(String[] args) {

// Creamos la conexion

        HikariConfig connectionPoolConfig = new HikariConfig();
        connectionPoolConfig.setJdbcUrl(CONNECTION_STRING);
        connectionPoolConfig.setUsername(user);
        connectionPoolConfig.setPassword(password);

//        Declaramos un max de connections
        connectionPoolConfig.setMaximumPoolSize(2);

//        connectionPoolConfig.setConnectionTimeout(1000);  // Establece el tiempo max que una conexion permanece abierta

        try(HikariDataSource dataSource = new HikariDataSource(connectionPoolConfig)){

            try(Connection connection = dataSource.getConnection()){
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
                ps.setString(1, "Alejandra");
                int numerosRegistros = ps.executeUpdate();
                System.out.printf("Se han actualizado %d registros\n", numerosRegistros);

                System.out.println("El tipo de la conexiñon obtenida con el pool es:");


            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }

// El valor de una variable que no esta declarado es = null

    }
}
