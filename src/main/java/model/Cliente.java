package model;

public class Cliente {
    private String idCliente;
    private String nombreCliente;
    private String generoCliente;
    private String pwCliente;
    private String usuarioCliente;

    public Cliente(String idCliente, String nombreCliente, String generoCliente, String pwCliente, String usuarioCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.generoCliente = generoCliente;
        this.pwCliente = pwCliente;
        this.usuarioCliente = usuarioCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String clienteId) {
        this.idCliente = clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getGeneroCliente() {
        return generoCliente;
    }

    public void setGeneroCliente(String generoCliente) {
        this.generoCliente = generoCliente;
    }

    public String getPwCliente() {
        return pwCliente;
    }

    public void setPwCliente(String pwCliente) {
        this.pwCliente = pwCliente;
    }

    public Cliente() {
    }
    
}
