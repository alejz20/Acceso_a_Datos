package org.alejandra.UT02_Manejo_Conectores.transaccion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploTransaccion {

    private static final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/sakila";
    private static final String user = "sakilauser";
    private static final String password = "pwdsakilauser";
    private static final String SQL_INSERT_PAIS = "insert into country (country) values (?)";


    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, user, password)) {

//            Ponemos transacciones explicictas
            connection.setAutoCommit(false);  // Detenemos las transacciones implicitas (osea,se no se guarda automaticamente )
            try {
//            Inserto un valor de DB
                InsertarCountry("Francia", connection);
                connection.commit(); // Por eso, tenemos este metodo Guardamos las transacciones

            } catch (SQLException e) {
                System.out.println("Deshago la transacción" + e.getMessage());
                connection.rollback();
            }
        }

    }
    public static void InsertarCountry(String nombrePais, Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PAIS)) {
            ps.setString(1, nombrePais);
            int numerosInsertados = ps.executeUpdate();
            System.out.println("Se han insertado %d registros\n" + numerosInsertados);
        }
        }
    }




