/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Congo
 */
@Named(value = "alertaController")
@SessionScoped
public class AlertaController implements Serializable {

   private boolean render;
   
    public AlertaController() {
        render = false;        
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    
}
