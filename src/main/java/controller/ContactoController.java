/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.AdopcionGestion;
import gestion.ContactoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Adopcion;
import model.Contacto;

/**
 *
 * @author Congo
 */
@Named(value = "contactoController")
@SessionScoped
public class ContactoController extends Contacto implements Serializable {

    /**
     * Creates a new instance of AdopcionController
     */
    public ContactoController() {
    }
    
    public String inserta() {        
      
        if (ContactoGestion.insertar(this)) {
            return "contacto.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible identificación duplicada...");
            FacesContext.getCurrentInstance().addMessage("contactoFormn", mensaje);
            return "contacto.xhtml";
        }
    }
    
}
