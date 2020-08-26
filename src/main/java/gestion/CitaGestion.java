package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cita;
import model.Conexion;

public class CitaGestion {
 private static final String SQL_INSERT_CITA = "insert into CITA values (?,?,?,?,?,?)";

   
    public static boolean insertar(Cita cita) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_CITA);
            sentencia.setString(1, cita.getIdCita());
            sentencia.setString(2, cita.getNombreMascota());
            sentencia.setString(3, cita.getRazaMascota());
            sentencia.setString(4, cita.getServicio());
            sentencia.setObject(5, cita.getFecha());
            sentencia.setObject(6, cita.getHora());
            
            int fila = sentencia.executeUpdate();
            return fila > 0; //retorna true si hay un número de fila >0...
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //devuelve falso... llegado a este punto...
    }

    private static final String SQL_UPDATE_CITA = "update estudiante set nombreMascota=?, razaMascota=?,"
            + "Servicio=?, fecha=?, hora=? where IDCita=?";

    
    public static boolean modificar(Cita cita) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_UPDATE_CITA);
            sentencia.setString(1, cita.getIdCita());
            sentencia.setString(2, cita.getNombreMascota());
            sentencia.setString(3, cita.getRazaMascota());
            sentencia.setString(4, cita.getServicio());
            sentencia.setObject(5, cita.getFecha());
            sentencia.setObject(6, cita.getHora());
            
            int fila = sentencia.executeUpdate();
            return fila > 0; //retorna true si hay un número de fila >0...
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //devuelve falso... llegado a este punto...
    }

    private static final String SQL_DELETE_CITA = "delete from CITA where id=?";

   
    public static boolean eliminar(Cita cita) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_DELETE_CITA);
            sentencia.setString(1, cita.getIdCita());
            int fila = sentencia.executeUpdate();
            return fila > 0; //retorna true si hay un número de fila >0...
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //devuelve falso... llegado a este punto...
    }

    private static final String SQL_SELECT_CITA = "select * from CITA where IdCita=?";

    //Retorna un Objecto Estudiante si lo encuentra... y null si no lo encuentra..
    public static Cita getCita(String id) {
        Cita cita = null;
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_SELECT_CITA);
            sentencia.setString(1, id);
            ResultSet datos = sentencia.executeQuery();
            if (datos.next()) {
                cita = new Cita();
            sentencia.setString(1, cita.getIdCita());
            sentencia.setString(2, cita.getNombreMascota());
            sentencia.setString(3, cita.getRazaMascota());
            sentencia.setString(4, cita.getServicio());
            sentencia.setObject(5, cita.getFecha());
            sentencia.setObject(6, cita.getHora());
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cita;
    }

   

    public static ArrayList<Cita> getCita() {
        ArrayList<Cita> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_CITA);
            ResultSet datos = sentencia.executeQuery();
            while (datos.next()) {
                lista.add(
                        new Cita(
                                
             sentencia.setString(1, Cita.getIdCita());
            sentencia.setString(2, Cita.getNombreMascota());
            sentencia.setString(3, Cita.getRazaMascota());
            sentencia.setString(4, Cita.getServicio());
            sentencia.setObject(5, Cita.getFecha());
            sentencia.setObject(6, Cita.getHora());    
            
            )          
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

   

   
}
