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
        System.out.println("\n=== CARACTERÍSTICAS DE PRODUCTOS ===");
        for (Caracteristicas_Productos cp : lista) {
            System.out.println(
                "Código: " + cp.getCodigoAuto() + 
                " | Marca: " + cp.getMarca() + 
                " | Modelo: " + cp.getModelo() +
                " | Año: " + cp.getAnio() +
                " | Color: " + cp.getColor()
            );
        }

        /*List<CaracteristicasProducto> lista = dao.operacionesLectura("consultar", new CaracteristicasProducto());
        System.out.println("Total características: " + lista.size());

        // Ejemplo de eliminación
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
        System.out.println("Resultado eliminación: " + resultado);
        */
    }
}