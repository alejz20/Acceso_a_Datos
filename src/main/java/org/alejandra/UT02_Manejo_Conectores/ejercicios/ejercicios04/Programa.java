package org.alejandra.UT02_Manejo_Conectores.ejercicios.ejercicios04;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String searchString = "";
        do {
            System.out.println("Introduce la cadena de búsqueda");
            searchString = scanner.nextLine();

            if (!searchString.isBlank()) {
                var results = ClientDataAccess.findClientsDetails(searchString);
                if (results.isEmpty()) {
                    System.out.printf("No se han encontrado clientes con '%s' en nobre o apellido.\n", searchString);
                } else {
                    showClientDetails(results);
                }
            }


        }while (!searchString.isBlank());

    }

    private static void showClientDetails(List<ClientDetails> results) {

        System.out.printf("Se han encontrado %d resultados:", results.size());
        results.forEach(System.out::println);

        // Ejemplo de como rfiltrar con streams usand expresiones regulares.
//        Regex regex = new Regex();
//        results.stream().filter(cd-> cd.getFirstName().matches(regex) || cd.getLastName().matches(regex))


    }

}
