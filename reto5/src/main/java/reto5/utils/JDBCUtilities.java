package reto5.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {

    private static final String UBICACION_BD = "src/main/java/reto5/DB/ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException, IOException {
        Path path = Paths.get(UBICACION_BD);
        System.out.println(path.toRealPath());
        String url = "jdbc:sqlite:" + path.toRealPath();
        return DriverManager.getConnection(url);
    }
}
