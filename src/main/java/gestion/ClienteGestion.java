package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Conexion;

public class ClienteGestion {

    private static final String SQL_SELECT_CLIENTE = "Select * from cliente where usuario=?";

    //Retorn null si no lo encuentra o la clave no es 
    //y el usuario si lo encuentra y la clave es correcta
    public static Cliente valida(String usuario, String clave) {
        Cliente cliente = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_CLIENTE);
            sentencia.setString(1, usuario);
            ResultSet rs = sentencia.executeQuery();
            if (rs != null && rs.next() && rs.getString(8).equals(clave)) {
                //  Si estoy acá el usuario existe y la clave es correcta...
                cliente = new Cliente(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        clave,
                        usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
    private static final String SQL_UPDATE_CLIENTE = "update cliente set nombre=?, apellido1=?,"
            + "apellido2=?, telefono=?, correo=?, usuario=?, clave=? where cedula=?";

    public static boolean modificar(Cliente cliente) {
                try {
                    PreparedStatement sentencia2
                            = Conexion.getConexion().prepareStatement(SQL_UPDATE_CLIENTE);
                    sentencia2.setString(1, cliente.getNombre());
                    sentencia2.setString(2, cliente.getApellido1());
                    sentencia2.setString(3, cliente.getApellido2());
                    sentencia2.setString(4, cliente.getTelefono());
                    sentencia2.setString(5, cliente.getCorreo());
                    sentencia2.setString(6, cliente.getUsuario());
                    sentencia2.setString(7, cliente.getClave());
                    sentencia2.setString(8, cliente.getCedula());

                    int fila = sentencia2.executeUpdate();
                    return fila > 0;
                } catch (SQLException ex) {
                    Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
                }       
        return false;
    }
    

}
