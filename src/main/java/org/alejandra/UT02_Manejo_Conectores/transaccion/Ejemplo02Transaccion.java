package org.alejandra.UT02_Manejo_Conectores.transaccion;

import java.sql.*;
import java.time.LocalDate;

public class Ejemplo02Transaccion {

    private static final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/sakila";
    private static final String user = "sakilauser";
    private static final String password = "pwdsakilauser";

    private static final String SQL_INSERT = "insert into prueba_transaccion (contenido, fecha_creacion) values (?, ?)";


    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, user, password)) {

//            Detenemos las transacciones implicitas
            connection.setAutoCommit(false);
            try{

                InsertDatosPrueba("contenido1", LocalDate.now(), connection);
                connection.commit(); //Se guardan/confirman
                System.out.println();

            }catch (SQLException e){
                System.out.println("Deshago la transacción" + e.getMessage());
                connection.rollback();
        }

        }

    }

    private static void InsertDatosPrueba(String contenido1,LocalDate now, Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(SQL_INSERT)) {
            ps.setString(1, contenido1);
            ps.setTimestamp(2, Timestamp.valueOf(now.atStartOfDay()));
            int numerosInsertados = ps.executeUpdate();
            System.out.println("Se han insertado %d registros\n" + numerosInsertados);
            connection.rollback();
        }
    }
}