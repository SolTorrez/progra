
package controller;

import gestion.ClienteGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Cliente;

/**
 *
 * @author Congo
 */
@Named(value = "clienteController")
@SessionScoped
public class ClienteController extends Cliente implements Serializable {

    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
    }
    
    public String valida() {
        
        Cliente cliente=ClienteGestion.valida(this.getIdCliente(),this.getPwCliente());
        
        if (cliente!=null) {  //El usuario existe y clave OK!
            this.setNombreCliente(cliente.getNombreCliente());
            return "index.xhtml";
        } else {  //No existe el usuario o la clave no es correcta...
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error", "Usuario/Clave incorrecto");
            FacesContext.getCurrentInstance().addMessage("loginForm, clave", msg);
            return "login.xhtml";
        }    
    }
    
    
}
