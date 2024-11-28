package org.alejandra.UT02_Manejo_Conectores.optional;

import java.sql.*;

public class Programa {

    private static final String CONNECTION_STRING = "jdbc:mariadb://localhost/sakila";
    private static final String USERNAME = "sakilauser";

    private static final String PASSWORD = "pwdsakilauser";
    private static final String SQL_FIND_FILM = "select filmId, title from Film where filmId = ?";

    public static void main(String[] args) throws SQLException {

        Film f  = findFilmByIConNulos(5000);

        f.getFilmId();

//        Optional<Film> f2 = findFilmByIdoptional(1);
//
//        int n = f2.orElseThrow().getFilmId();
//
//        if (f2.isPresent()){
//            System.out.println(f2.get().getTitle());
        }


//    }

    private static Film findFilmByIConNulos(int filmId) throws SQLException {
        try(Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD); //Establecemos la conexion
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_FILM)){
            ps.setInt(1, filmId);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.isBeforeFirst()){
                    rs.next();
                    Film f = new Film(rs.getInt("filmId"), rs.getString("title"));
                    return null;
                }
            }
          return null;
        }

    }




}
