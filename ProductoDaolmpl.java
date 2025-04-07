package com.idat.dao.daolmpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.idat.conexion.ConectarSql;
import com.idat.dao.IProductoDao;
import com.idat.entidades.Producto;

public class ProductoDaolmpl implements IProductoDao {

    @Override
    public int OperacionesEscritura(String indicador, Producto p) {
        int procesar = -1;
        String query = "{call usp_producto_crud(?,?,?,?,?,?)}";
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, p.getCodigoProducto());
            cst.setString(3, p.getNombre());
            cst.setDouble(4, p.getPrecio());
            cst.setInt(5, p.getStockActual());
            cst.setInt(6, p.getStockMinimo());
            cst.setInt(7, p.getStockMaximo());
            
            procesar = cst.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("operacionesEscritura-Error:" + ex.getMessage());
        }
        return procesar;
    }

    @Override
    public List<Producto> OperacionesLectura(String indicador, Producto p) {
        List<Producto> lista = new ArrayList<Producto>();
        String query = "{call usp_producto_crud(?,?,?,?,?,?,?)}";
        
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, p.getCodigoProducto());
            cst.setString(3, p.getNombre());
            cst.setDouble(4, p.getPrecio());
            cst.setInt(5, p.getStockActual());
            cst.setInt(6, p.getStockMinimo());
            cst.setInt(7, p.getStockMaximo());
            
            try (ResultSet rs = cst.executeQuery()) {
                Producto objProd;
                while (rs.next()) {
                    objProd = new Producto(
                        rs.getInt("codigoProducto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stockActual"),
                        rs.getInt("stockMinimo"),
                        rs.getInt("stockMaximo")
                    );
                    lista.add(objProd);
                }
            }
            
        } catch (Exception ex) {
            System.out.println("operacionesLectura-Error:" + ex.getMessage());
        }
        return lista;
    }
}