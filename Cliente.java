package com.idat.entidades;

public class Cliente {
    private int codigoCliente;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String dni;

    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(int codigoCliente, String nombres, String apellidos, String direccion, String telefono, String dni) {
        this.codigoCliente = codigoCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
    }

    // Getters y Setters
    public int getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(int codigoCliente) { this.codigoCliente = codigoCliente; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDNI() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
}