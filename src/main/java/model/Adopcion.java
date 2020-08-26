/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Congo
 */
public class Adopcion {
    
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String mensaje;

    public Adopcion(){
        
    }
    
    public Adopcion(String id, String nombre, String apellido, String telefono, String correo, String mensaje){
    this.id=id;
    this.nombre=nombre;
    this.apellido=apellido;
    this.telefono=telefono;
    this.correo=correo;
    this.mensaje=mensaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
