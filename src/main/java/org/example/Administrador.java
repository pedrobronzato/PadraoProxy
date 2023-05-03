package org.example;

public class Administrador {

    private String username;
    private boolean administrador;

    public Administrador(String username, boolean administrador) {
        this.username = username;
        this.administrador = administrador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdministradorMaster() {
        return administrador;
    }

    public void setAdministradorMaster(boolean administrador) {
        this.administrador = administrador;
    }
}
