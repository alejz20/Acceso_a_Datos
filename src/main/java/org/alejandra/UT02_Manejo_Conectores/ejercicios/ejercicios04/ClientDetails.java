package org.alejandra.UT02_Manejo_Conectores.ejercicios.ejercicios04;


import lombok.*;

import java.time.LocalDateTime;

//creamos una clase inmutable, que siginifica que su valor no puede cambiarse despues de declararse


@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true) // solo muestra los atributos incluidos, no los demas. X ejemplo:
public class ClientDetails {

    @EqualsAndHashCode.Include
    @ToString.Include
    private final int id;
    @ToString.Include
    private final String name;
    @ToString.Include
    private final String last_name;
    private final String email;
    private final Boolean active;
    private final LocalDateTime last_update;
    @Getter(AccessLevel.NONE) // Se utiliza para evitar que genere automaticamente un método gettter .
    private final String addressLine1;
    @Getter(AccessLevel.NONE)
    private final String addressLine2;
    private final String district;
    private final String city;
    private final String country;


    public String getfullName() {
        return String.format("%s %s", name, last_name); //  devolverá una nueva cadena que concatena name y last_name, separados por un espacio."Juan Pérez"
    }

    public String getfullAddress() {
        return String.format("%s\n%s", addressLine1, addressLine2); // devuelve una nueva cadena en la que addressLine1 aparece en la primera línea y addressLine2 en la segunda, separados por un salto de línea.
//        Por Ejemplo: 123 Main St
//                     Apt 4B
    }


}
