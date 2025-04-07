package com.idat.main;

import java.util.List;
import com.idat.dao.IProductoDao;
import com.idat.dao.daolmpl.ProductoDaolmpl;
import com.idat.entidades.Producto;

public class MainProducto {

    public static void main(String[] args) {
        IProductoDao dao = new ProductoDaolmpl();
        
        // Consulta general de productos
        List<Producto> lista = dao.OperacionesLectura("consultar", new Producto());
        System.out.println("\n=== LISTA DE PRODUCTOS (" + lista.size() + ") ===");
        for (Producto p : lista) {
            System.out.println(
                "Código: " + p.getCodigoProducto() + 
                " | Nombre: " + p.getNombre() + 
                " | Precio: S/" + p.getPrecio() +
                " | Stock: " + p.getStockActual()
            );
        }
        
        //List<Producto> lista = dao.operacionesLectura("consultar", new Producto());
        //System.out.println("Total registros: "+ lista.size());

        //Producto objProd = new Producto();
        //objProd.setCodigoProducto(0);
        //objProd.setNombre("");
        //objProd.setPrecio(0);
        //objProd.setStockActual(0);
        //objProd.setStockMinimo(0);
        //objProd.setStockMaximo(0);
        
        //int procesar = dao.operacionesEscritura("eliminar", objProd);
        //System.out.println("Procesar: "+ procesar);

    }
}