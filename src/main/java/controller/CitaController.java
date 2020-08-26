/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.CitaGestion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Cita;

/**
 *
 * @author Congo
 */
@Named(value = "citaController")
@Dependent
public class CitaController extends Cita implements Serializable {

    /**
     * Creates a new instance of CitaController
     */
    public CitaController() {
    }
    
    public ArrayList<Cita> getCitas(){
        ArrayList listaCita = CitaGestion.getCita();
        return listaCita;
    }
    public String inserta() {        
        //Si puedo insertar el estudiante...
        if (CitaGestion.insertar(this)) {
            return "list.xhtml";
        } else {  //si no pudo insertarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible indentificación duplicada...");
            FacesContext.getCurrentInstance().addMessage("editaCitaForm:identificacion", mensaje);
            return "listaCitas.xhtml";
        }
    }
    
    public String modifica() {        
        //Si puedo modificar el estudiante...
        if (CitaGestion.modificar(this)) {
            return "list.xhtml";
        } else {  //si no pudo modificarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible indentificación duplicada...");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "listaCitas.xhtml";
        }
    }
    
    public String elimina() {        
        //Si puedo eliminar el estudiante...
        if (CitaGestion.eliminar(this)) {
            return "list.xhtml";
        } else {  //si no pudo eliminarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","No puede eliminar un estudiante si tiene notas...");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "listaCitas.xhtml";
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
            return "list.xhtml";
        }
    }   
    
    public List<Cita> getCita() {
        return CitaGestion.getCita();
    }
    
    private boolean noImprimir=true; //para apagar el boton de imprimir...
    public boolean isNoImprimir() {
        return noImprimir;
    }
    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }
    public void buscaEstudiante(String id) {
        Estudiante estudiante = EstudianteGestion.getEstudiante(id);
        if (estudiante!=null) {
            this.setId(estudiante.getId());
            this.setNombre(estudiante.getNombre());
            this.setApellido1(estudiante.getApellido1());
            this.setApellido2(estudiante.getApellido2());
            this.setFechaNaci(estudiante.getFechaNaci());
            this.setFechaIngr(estudiante.getFechaIngr());
            this.setGenero(estudiante.getGenero());
            noImprimir=false; //para encender el boton de imprimir...
        } else {  //No lo encontró....
            this.setNombre("");
            this.setApellido1("");
            this.setApellido2("");
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,
            "Error","Estudiante no encontrado...");
            FacesContext
                    .getCurrentInstance()
                    .addMessage("certificacionNotasForm:identificacion", mensaje);
            noImprimir=true; //para apagar el boton de imprimir...
        }
    }
}
