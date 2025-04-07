package com.idat.main;

import java.util.List;
import com.idat.dao.ICaracteristicas_ProductosDao;
import com.idat.dao.daolmpl.Caracteristicas_ProductosDaolmpl;
import com.idat.entidades.Caracteristicas_Productos;

public class MainCaracteristicas_Productos {

    public static void main(String[] args) {
        ICaracteristicas_ProductosDao dao = new Caracteristicas_ProductosDaolmpl();
        
        // Consulta general
        List<Caracteristicas_Productos> lista = dao.OperacionesLectura("consultar", new Caracteristicas_Productos());
        System.out.println("\n=== CARACTER�STICAS DE PRODUCTOS ===");
        for (Caracteristicas_Productos cp : lista) {
            System.out.println(
                "C�digo: " + cp.getCodigoAuto() + 
                " | Marca: " + cp.getMarca() + 
                " | Modelo: " + cp.getModelo() +
                " | A�o: " + cp.getAnio() +
                " | Color: " + cp.getColor()
            );
        }

        /*List<CaracteristicasProducto> lista = dao.operacionesLectura("consultar", new CaracteristicasProducto());
        System.out.println("Total caracter�sticas: " + lista.size());

        // Ejemplo de eliminaci�n
        CaracteristicasProducto objCaract = new CaracteristicasProducto();
        objCaract.setCodigoAuto(0);
        objCaract.setMarca("");
        objCaract.setModelo("");
        objCaract.setAnio(0);
        objCaract.setColor("");
        objCaract.setTipoCombustible("");
        objCaract.setCilindrada(0);
        objCaract.setNumeroPuertas(0);
        objCaract.setEsAutomatico(false);
        objCaract.setCodigoProducto(0);
        
        int resultado = dao.operacionesEscritura("eliminar", objCaract);
        System.out.println("Resultado eliminaci�n: " + resultado);
        */
    }
}