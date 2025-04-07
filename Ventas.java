package com.idat.entidades;

import java.util.Date;

public class Ventas {
    private int codigoVenta;
    private int codigoCliente;
    private int codigoProducto;
    private int cantidad;
    private double precio;
    private Date fecha;

    // Constructor vacío
    public Ventas() {}

    // Constructor con parámetros
    public Ventas(int codigoVenta, int codigoCliente, int codigoProducto, 
                 int cantidad, double precio, Date fecha) {
        this.codigoVenta = codigoVenta;
        this.codigoCliente = codigoCliente;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getCodigoVenta() { return codigoVenta; }
    public void setCodigoVenta(int codigoVenta) { this.codigoVenta = codigoVenta; }

    public int getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(int codigoCliente) { this.codigoCliente = codigoCliente; }

    public int getCodigoProducto() { return codigoProducto; }
    public void setCodigoProducto(int codigoProducto) { this.codigoProducto = codigoProducto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}