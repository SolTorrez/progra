
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


@Named(value = "citaController")
@Dependent
public class CitaController extends Cita implements Serializable {

  
    public CitaController() {
    }
    
    public ArrayList<Cita> getCitas(){
        ArrayList listaCita = CitaGestion.getCita();
        return listaCita;
    }
    public String inserta() {        
      
        if (CitaGestion.insertar(this)) {
            return "list.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible indentificación duplicada...");
            FacesContext.getCurrentInstance().addMessage("editaCitaForm:identificacion", mensaje);
            return "listaCitas.xhtml";
        }
    }
    
    public String modifica() {        
        
        if (CitaGestion.modificar(this)) {
            return "list.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible indentificación duplicada...");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "listaCitas.xhtml";
        }
    }
    
    public String elimina() {        
        
        if (CitaGestion.eliminar(this)) {
            return "list.xhtml";
        } else {  
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
    
    private boolean noImprimir=true; 
    public boolean isNoImprimir() {
        return noImprimir;
    }
    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }
    public void buscaEstudiante(String id) {
        Cita cita = CitaGestion.getCita(id);
        if (cita!=null) {
             this.setIdCita(cita.getIdCita());
            this.setNombreMascota(cita.getNombreMascota());
            this.setRazaMascota(cita.getRazaMascota());
            this.setServicio(cita.getServicio());
            this.setFecha(cita.getFecha());
            this.setHora(cita.getHora());
            
            noImprimir=false; 
        } else {  
            this.setNombreMascota("");
            this.setRazaMascota("");
            this.setServicio("");
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,
            "Error","Cita no existente...");
           
                    
            noImprimir=true;
        }
    }
}
