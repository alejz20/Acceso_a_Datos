package org.alejandra.UT02_Manejo_Conectores.optional;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Film {

    @EqualsAndHashCode.Include
    private int filmId;

    private String title;
}
