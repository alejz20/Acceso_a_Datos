package org.alejandra.UT02_Manejo_Conectores.ejercicios.ejercicios02;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;



public class Ejercicio02 {
    private static final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/sakila";
    private static final String user = "sakilauser";
    private static final String password = "pwdsakilauser";

    private static final String SQL_INSERT = "insert into city (city, last_update, country_id) values (?, ?, ?)";

    public static <Int> void main(String[] args) {

//         Pedimos al usuario que introduzca una insercción

        Scanner  sc = new Scanner(System.in);

/* --> start try --> */   try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, user, password);
                 PreparedStatement ps = connection.prepareStatement(SQL_INSERT)){
                 connection.setAutoCommit(false);

                System.out.println("Introduce un valor para la columna city:");
                String contenido = sc.nextLine();


                while (!contenido.equals("FIN")){

                ps.setString(1, contenido);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(3, 65);

                int numerosInsertados = ps.executeUpdate();
                System.out.println("Se han insertado %d registros\n" + numerosInsertados);

                System.out.println("Introduce un valor para la columna contenido:");
                contenido = sc.nextLine();
              }

//                Cualquier transaccion nueva que haya despues del commit, no serviria. Lo q daria error
                connection.commit();

                // Linea que provoca error --- -> Aunque hay error ya se ha confirmado


            }  /*<!-- end try -->*/ catch (SQLException e) {
                // connection.rollback(); // Esta da error xq connection esta fuera de su ambito
                System.err.println("Error al insertar: " );
                e.printStackTrace();
            }
            System.out.println("Terminado el programa");

        }
}
