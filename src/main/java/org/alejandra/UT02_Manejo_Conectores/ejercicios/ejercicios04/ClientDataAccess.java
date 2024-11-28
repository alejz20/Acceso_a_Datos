package org.alejandra.UT02_Manejo_Conectores.ejercicios.ejercicios04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClientDataAccess {

    private static final String SQL_FIND_CLIENT_DETAILS = """
            select *
            from customer
                    join sakila.address on customer.address_id = address.address_id
                    join sakila.city on address.city_id = city.city_id
                    join sakila.country on country_id = country.country_id
            where
             first_name like ? or last_name like ?
             
            """;

    static List<ClientDetails> findClientsDetails(String search) throws SQLException {

    /*
    * 0 - Crear una lista vacía
    * 1 - Abrir conexion - Pedirla al pool de conexiones
    * 2 - Crear un PreparedStatement con el SQL adecuado y pasar parametros
    * 3 - Ejecutar la PS y obtener un ResulSet
    * 4 - Recorrer ResulSet y llenar la lista de ClientDetails
    * 5 - Cerrar la conexión
    * 6 - Devolver la lista
    * */

//        Paso 0
        List<ClientDetails> result = new ArrayList<>();

//        Paso 1 y paso 5 // El try-with-resources cierra la conexión

        try(Connection connection = SakilaConnectionPool.getInstance().getConnection();
            //            Paso 2
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_CLIENT_DETAILS)){
            search = "%" + search + "%";
            ps.setString(1,search);
            ps.setString(2,search);


//            Paso 3
            try(ResultSet rs = ps.executeQuery()) {
//                Paso 4

                while (rs.next()) {
                    int clientId = rs.getInt("customer_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    Boolean active = rs.getBoolean("active");
                    LocalDateTime last_update = rs.getTimestamp("last_update").toLocalDateTime();
                    String addressLine1 = rs.getString("addressLine1");
                    String addressLine2 = rs.getString("addressLine2");
                    String district = rs.getString("district");
                    String city = rs.getString("city");
                    String country = rs.getString("country");

                    ClientDetails cd = new ClientDetails(clientId, firstName, lastName, email, active, last_update, addressLine1, addressLine2, district, city, country);

                    result.add(cd);


                }
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error al buscar clientes" , e);
        }

//        Paso 6
        return result;

    }
}

