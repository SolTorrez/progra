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

    private boolean autenticado;
    private boolean noAutenticado;

    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {

        noAutenticado = true;
        autenticado = false;
    }

    public boolean isNoAutenticado() {
        return noAutenticado;
    }

    public void setNoAutenticado(boolean noAutenticado) {
        this.noAutenticado = noAutenticado;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String valida() {

        Cliente cliente = ClienteGestion.valida(this.getIdCliente(), this.getPwCliente());

        if (cliente != null) {  //El usuario existe y clave OK!
            this.setNombreCliente(cliente.getNombreCliente());
            autenticado = true;
            noAutenticado = false;
            return "principal.xhtml";
        } else {  //No existe el usuario o la clave no es correcta...
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Usuario/Clave incorrecto");
            FacesContext.getCurrentInstance().addMessage("loginForm, clave", msg);
            autenticado = false;
            noAutenticado = true;
            return "index.xhtml";
        }
    }
}
