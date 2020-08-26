/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.AdopcionGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Adopcion;

/**
 *
 * @author Congo
 */
@Named(value = "adopcionController")
@SessionScoped
public class AdopcionController extends Adopcion implements Serializable {

    /**
     * Creates a new instance of AdopcionController
     */
    public AdopcionController() {
    }
    
    public String inserta() {        
      
        if (AdopcionGestion.insertar(this)) {
            return "confirmacion.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible indentificación duplicada...");
            FacesContext.getCurrentInstance().addMessage("editaCitaForm:identificacion", mensaje);
            return "formularioAdopcion.xhtml";
        }
    }
    
}
