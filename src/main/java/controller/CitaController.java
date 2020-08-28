/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.CitaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Cita;

/**
 *
 * @author Congo
 */
@Named(value = "citaController")
@SessionScoped
public class CitaController extends Cita implements Serializable {

    /**
     * Creates a new instance of CitaController
     */
    public CitaController() {
    }
    
    public ArrayList<Cita> getCitas(){
        ArrayList listaCita = CitaGestion.getCitas();
        return listaCita;
    }
    public String inserta() {        
      
        if (CitaGestion.insertar(this)) {
            return "principal.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Faltan datos");
            FacesContext.getCurrentInstance().addMessage("agendarForm", mensaje);
            return "agendar.xhtml";
        }
    }
    
    public String modifica() {        
        
        if (CitaGestion.modificar(this)) {
            return "listaCitas.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Faltan Datos");
            FacesContext.getCurrentInstance().addMessage("editaCitasForm", mensaje);
            return "editaCita.xhtml";
        }
    }
    
    public String elimina() {        
        
        if (CitaGestion.eliminar(this)) {
            return "listaCitas.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","No puede eliminar un estudiante si tiene notas...");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "editaCita.xhtml";
        }
    }
    
    public String edita(String id) {
        Cita cita=CitaGestion.getCita(id);
        if (cita!=null) {
            this.setIdCita(cita.getIdCita());
            this.setNombreMascota(cita.getNombreMascota());
            this.setRazaMascota(cita.getRazaMascota());
            this.setServicio(cita.getServicio());
            this.setFecha(cita.getFecha());
            this.setHora(cita.getHora());
           
            return "listaCitas.xhtml";
        } else {
            return "editaCita.xhtml";
        }
    }   
    
    public static List<Cita> getCita() {
        return CitaGestion.getCitas();
    }
    
    
}
