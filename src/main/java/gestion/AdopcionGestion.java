/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Adopcion;
import model.Conexion;

/**
 *
 * @author Congo
 */
public class AdopcionGestion {
    
    private static final String SQL_INSERT_ADOPCION = "INSERT INTO ADOPCION VALUES (?,?,?,?,?,?)";
    
     public static boolean insertar(Adopcion adopcion) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_ADOPCION);
            sentencia.setString(1, adopcion.getId());
            sentencia.setString(2, adopcion.getNombre());
            sentencia.setString(3, adopcion.getApellido());
            sentencia.setString(4, adopcion.getTelefono());
            sentencia.setObject(5, adopcion.getCorreo());
            sentencia.setObject(6, adopcion.getMensaje()); 
                
            int fila = sentencia.executeUpdate();
            return fila > 0; 
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
}
