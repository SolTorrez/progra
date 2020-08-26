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
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_ESTUDIANTE);
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

    private static final String SQL_UPDATE_ESTUDIANTE = "update estudiante set nombre=?, apellido1=?,"
            + "apellido2=?, fechaNaci=?, fechaIngr=?, genero=? where id=?";

    
    public static boolean modificar(Cita cita) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_UPDATE_ESTUDIANTE);
            sentencia.setString(1, cita.getNombre());
            sentencia.setString(2, cita.getApellido1());
            sentencia.setString(3, cita.getApellido2());
            sentencia.setObject(4, cita.getFechaNaci());
            sentencia.setObject(5, cita.getFechaIngr());
            sentencia.setString(6, "" + cita.getGenero());
            sentencia.setString(7, cita.getId());
            int fila = sentencia.executeUpdate();
            return fila > 0; //retorna true si hay un número de fila >0...
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //devuelve falso... llegado a este punto...
    }

    private static final String SQL_DELETE_ESTUDIANTE = "delete from estudiante where id=?";

   
    public static boolean eliminar(Cita cita) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_DELETE_ESTUDIANTE);
            sentencia.setString(1, cita.getId());
            int fila = sentencia.executeUpdate();
            return fila > 0; //retorna true si hay un número de fila >0...
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //devuelve falso... llegado a este punto...
    }

    private static final String SQL_SELECT_ESTUDIANTE = "select * from estudiante where id=?";

    //Retorna un Objecto Estudiante si lo encuentra... y null si no lo encuentra..
    public static Cita getCita(String id) {
        Cita cita = null;
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_SELECT_ESTUDIANTE);
            sentencia.setString(1, id);
            ResultSet datos = sentencia.executeQuery();
            if (datos.next()) {
                cita = new Cita(
                        datos.getString(1), //id
                        datos.getString(2), //nombre
                        datos.getString(3), //apellido1
                        datos.getString(4), //apellido2
                        datos.getDate(5), //fecha nacimiento
                        datos.getDate(6), //FEcha de ingreso
                        datos.getString(7).charAt(0)); //El genero
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cita;
    }

    private static final String SQL_SELECT_ESTUDIANTES = "select * from estudiante";

    public static ArrayList<Cita> getCita() {
        ArrayList<Cita> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_ESTUDIANTES);
            ResultSet datos = sentencia.executeQuery();
            while (datos.next()) {
                lista.add(
                        new Cita(
                                datos.getString(1), //id
                                datos.getString(2), //nombre
                                datos.getString(3), //apellido1
                                datos.getString(4), //apellido2
                                datos.getDate(5), //fecha nacimiento
                                datos.getDate(6), //FEcha de ingreso
                                datos.getString(7).charAt(0) //El genero                                
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

   

   
}
