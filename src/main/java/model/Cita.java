
package model;

import java.util.Date;


public class Cita {
    private String idCita;
    private String nombreMascota;
    private String razaMascota;
    private String servicio;
    private Date fecha;
    private String hora;

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Cita(String idCita, String nombreMascota, String razaMascota, String servicio, Date fecha, String hora) {
        this.idCita = idCita;
        this.nombreMascota = nombreMascota;
        this.razaMascota = razaMascota;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cita() {
    }
}
