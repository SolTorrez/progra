/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private String ced;
    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
ced="";
    }

    public String valida() {

        Cliente cliente = ClienteGestion.valida(this.getUsuario(), this.getClave());

        if (cliente != null) {  //El usuario existe y clave OK!
            this.setNombre(cliente.getNombre());
            ced= ced + cliente.getCedula();
            return "principal.xhtml";
        } else {  //No existe el usuario o la clave no es correcta...
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Usuario/Clave incorrecto");
            FacesContext.getCurrentInstance().addMessage("loginForm", msg);
            return "index.xhtml";
        }
    }
    
    public String modifica() {   
        
            if (ClienteGestion.modificar(this)) {
            return "editaCliente.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Faltan Datos");
            FacesContext.getCurrentInstance().addMessage("editaCliente", mensaje);
            return "editaCliente.xhtml";
        }
           
    }
}
