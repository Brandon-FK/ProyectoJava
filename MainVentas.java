package com.idat.main;

import java.util.List;
import com.idat.dao.IVentasDao;
import com.idat.dao.daolmpl.VentasDaolmpl;
import com.idat.entidades.Ventas;

public class MainVentas {

    public static void main(String[] args) {
        IVentasDao dao = new VentasDaolmpl();
        
        // Consulta general
        List<Ventas> lista = dao.OperacionesLectura("consultar", new Ventas());
        System.out.println("\n=== REGISTRO DE VENTAS ===");
        for (Ventas v : lista) {
            System.out.println(
                "Venta #" + v.getCodigoVenta() + 
                " | Cliente: " + v.getCodigoCliente() + 
                " | Producto: " + v.getCodigoProducto() +
                " | Fecha: " + v.getFecha()
            );
        }

        /* List<Venta> lista = dao.operacionesLectura("consultar", new Venta());
        System.out.println("Total registros: "+ lista.size());

        Venta objVenta = new Venta();
        objVenta.setCodigoVenta(0);
        objVenta.setCodigoCliente(0);
        objVenta.setCodigoProducto(0);
        objVenta.setCantidad(0);
        objVenta.setPrecio(0);
        objVenta.setFecha(new Date());
        
        int procesar = dao.operacionesEscritura("eliminar", objVenta);
        System.out.println("Procesar: "+ procesar);
        */
    }
}