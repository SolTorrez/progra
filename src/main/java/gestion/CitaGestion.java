package gestion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cita;
import model.Conexion;

public class CitaGestion {

    private static final String SQL_INSERT_CITA = "insert into CITA (nombre_mascota, raza_mascota, servicio, fecha, hora) values (?,?,?,?,?)";
    private static final String SQL_SELECT_REVISACITAINSERT = "Select fecha, hora from cita where fecha='?' and hora='?'";

    public static boolean insertar(Cita cita) {
        try {
            PreparedStatement sentencia2
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_CITA);
            sentencia2.setString(1, cita.getNombreMascota());
            sentencia2.setString(2, cita.getRazaMascota());
            sentencia2.setString(3, cita.getServicio());
            sentencia2.setObject(4, cita.getFecha());
            sentencia2.setString(5, cita.getHora());

            int fila = sentencia2.executeUpdate();
            return fila > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static final String SQL_UPDATE_CITA = "update cita set Nombre_Mascota=?, Raza_Mascota=?,"
            + "Servicio=?, fecha=?, hora=? where ID=?";

    public static boolean modificar(Cita cita) {
                try {
                    PreparedStatement sentencia2
                            = Conexion.getConexion().prepareStatement(SQL_UPDATE_CITA);
                    sentencia2.setString(1, cita.getNombreMascota());
                    sentencia2.setString(2, cita.getRazaMascota());
                    sentencia2.setString(3, cita.getServicio());
                    sentencia2.setObject(4, cita.getFecha());
                    sentencia2.setString(5, cita.getHora());
                    sentencia2.setString(6, cita.getIdCita());

                    int fila = sentencia2.executeUpdate();
                    return fila > 0;
                } catch (SQLException ex) {
                    Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
                }       
        return false;
    }

    private static final String SQL_DELETE_CITA = "delete from CITA where id=?";

    public static boolean eliminar(Cita cita) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_DELETE_CITA);
            sentencia.setString(1, cita.getIdCita());
            int fila = sentencia.executeUpdate();
            return fila > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static final String SQL_SELECT_CITA = "select * from CITA";

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
                sentencia.setString(6, cita.getHora());

            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cita;
    }

    public static ArrayList<Cita> getCitas() {
        ArrayList listaCita = new ArrayList();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CITA);
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                Cita nuevo = new Cita(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6));
                listaCita.add(nuevo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCita;
    }
}
