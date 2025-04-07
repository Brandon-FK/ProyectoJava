package com.idat.entidades;

public class Caracteristicas_Productos {
    private int codigoAuto;
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private String tipoCombustible;
    private double cilindrada;
    private int numeroPuertas;
    private boolean esAutomatico;
    private int codigoProducto;

    // Constructor vacío
    public Caracteristicas_Productos() {}

    // Constructor con parámetros
    public Caracteristicas_Productos(int codigoAuto, String marca, String modelo, int anio, 
                                  String color, String tipoCombustible, double cilindrada, 
                                  int numeroPuertas, boolean esAutomatico, int codigoProducto) {
        this.codigoAuto = codigoAuto;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.cilindrada = cilindrada;
        this.numeroPuertas = numeroPuertas;
        this.esAutomatico = esAutomatico;
        this.codigoProducto = codigoProducto;
    }

    // Getters y Setters
    public int getCodigoAuto() { return codigoAuto; }
    public void setCodigoAuto(int codigoAuto) { this.codigoAuto = codigoAuto; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }

    public double getCilindrada() { return cilindrada; }
    public void setCilindrada(double cilindrada) { this.cilindrada = cilindrada; }

    public int getNumeroPuertas() { return numeroPuertas; }
    public void setNumeroPuertas(int numeroPuertas) { this.numeroPuertas = numeroPuertas; }

    public boolean isEsAutomatico() { return esAutomatico; }
    public void setEsAutomatico(boolean esAutomatico) { this.esAutomatico = esAutomatico; }

    public int getCodigoProducto() { return codigoProducto; }
    public void setCodigoProducto(int codigoProducto) { this.codigoProducto = codigoProducto; }
}