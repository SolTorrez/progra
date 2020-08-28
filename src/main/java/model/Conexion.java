package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
        private static Conexion conexion;
    private static final String DBURL="jdbc:derby://localhost:1527/VeterinariaLovePets";
    private static Connection conn;

    public static PreparedStatement getConexion(String SQL_SELECT_REVISACITA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Conexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").getDeclaredConstructor().newInstance();
            conn=DriverManager.getConnection(DBURL,"root","root");
        } catch (ClassNotFoundException | NoSuchMethodException | 
                SecurityException | InstantiationException | 
                IllegalAccessException | IllegalArgumentException | 
                InvocationTargetException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized Connection getConexion() {
        if (conexion==null) {
            conexion = new Conexion();
        }
        return conn;
    }
}