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
import model.Conexion;
import model.Contacto;

/**
 *
 * @author Congo
 */
public class ContactoGestion {
    
    private static final String SQL_INSERT_CONTACTO = "INSERT INTO CONTACTO VALUES (?,?,?,?,?,?)";
    
     public static boolean insertar(Contacto contacto) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_CONTACTO);
            sentencia.setString(1, contacto.getId());
            sentencia.setString(2, contacto.getNombre());
            sentencia.setString(3, contacto.getApellido());
            sentencia.setString(4, contacto.getTelefono());
            sentencia.setObject(5, contacto.getCorreo());
            sentencia.setObject(6, contacto.getMensaje()); 
                
            int fila = sentencia.executeUpdate();
            return fila > 0; 
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
}
