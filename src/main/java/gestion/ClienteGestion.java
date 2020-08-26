package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Conexion;

public class ClienteGestion {

    private static final String SQL_SELECT_CLIENTE = "Select * from cliente where usuarioCliente=?";

    //Retorn null si no lo encuentra o la clave no es 
    //y el usuario si lo encuentra y la clave es correcta
    public static Cliente valida(String usuarioCliente, String pwCliente) {
        Cliente cliente = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_CLIENTE);
            sentencia.setString(1, usuarioCliente);
            ResultSet rs = sentencia.executeQuery();
            if (rs != null && rs.next() && rs.getString(4).equals(pwCliente)) {
                //  Si estoy acá el usuario existe y la clave es correcta...
                cliente = new Cliente(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        pwCliente,
                        usuarioCliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}
