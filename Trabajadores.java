package com.idat.entidades;


import com.idat.entidades.Trabajadores;

public class Trabajadores {
    private int codigoUsuario;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String rol;

    // Constructor vacío
    public Trabajadores() {}

    // Constructor con parámetros
    public Trabajadores(int codigoUsuario, String nombre, String usuario, String contraseña, String rol) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    // Getters y Setters
    public int getCodigoUsuario() { return codigoUsuario; }
    public void setCodigoUsuario(int codigoUsuario) { this.codigoUsuario = codigoUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}