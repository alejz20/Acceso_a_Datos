package org.alejandra.UT02_Manejo_Conectores.ejercicios.ejercicios03;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ejercicio03 {

    private static final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/sakila";
    private static final String user = "sakilauser";
    private static final String password = "pwdsakilauser";

    private static final String SQL_INSERT = "insert into prueba_transaccion (contenido, fecha_creacion) values (?, ?)";

    public static void main(String[] args) {



//         Pedimos al usuario que introduzca una insercción

            Scanner sc = new Scanner(System.in);

            try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, user, password);
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT)){
                connection.setAutoCommit(false);

                System.out.println("Introduce un valor para la columna contenido:");
                String contenido = sc.nextLine();

                while (!contenido.equals("FIN")){
                    ps.setString(1, contenido);
                    ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

                    int numerosInsertados = ps.executeUpdate();
                    System.out.println("Se han insertado $d registros\n" + numerosInsertados);
                     int TAMANIO_LOTE = 10;
                     int contador = 0;

                    contador++;
                    if(contador % TAMANIO_LOTE == 0){
                        connection.commit();

                    }
                    System.out.println("Introduce un valor para la columna contenido:");
                    contenido = sc.nextLine();
                }

                connection.commit();



            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println("Terminado el programa");

        }



}
