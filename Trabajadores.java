package com.idat.entidades;


import com.idat.entidades.Trabajadores;

public class Trabajadores {
    private int codigoUsuario;
    private String nombre;
    private String usuario;
    private String contrase�a;
    private String rol;

    // Constructor vac�o
    public Trabajadores() {}

    // Constructor con par�metros
    public Trabajadores(int codigoUsuario, String nombre, String usuario, String contrase�a, String rol) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrase�a = contrase�a;
        this.rol = rol;
    }

    // Getters y Setters
    public int getCodigoUsuario() { return codigoUsuario; }
    public void setCodigoUsuario(int codigoUsuario) { this.codigoUsuario = codigoUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrase�a() { return contrase�a; }
    public void setContrase�a(String contrase�a) { this.contrase�a = contrase�a; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}