package com.idat.dao.daolmpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.idat.conexion.ConectarSql;
import com.idat.dao.IVentasDao;
import com.idat.entidades.Ventas;

public class VentasDaolmpl implements IVentasDao {

    @Override
    public int OperacionesEscritura(String indicador, Ventas v) {
        int procesar = -1;
        String query = "{call usp_venta_crud(?,?,?,?,?,?,?)}";
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, v.getCodigoVenta());
            cst.setInt(3, v.getCodigoCliente());
            cst.setInt(4, v.getCodigoProducto());
            cst.setInt(5, v.getCantidad());
            cst.setDouble(6, v.getPrecio());
            cst.setDate(7, new java.sql.Date(v.getFecha().getTime()));
            
            procesar = cst.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("operacionesEscritura-Error:" + ex.getMessage());
        }
        return procesar;
    }

    @Override
    public List<Ventas> OperacionesLectura(String indicador, Ventas v) {
        List<Ventas> lista = new ArrayList<Ventas>();
        String query = "{call usp_venta_crud(?,?,?,?,?,?,?)}";
        
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, v.getCodigoVenta());
            cst.setInt(3, v.getCodigoCliente());
            cst.setInt(4, v.getCodigoProducto());
            cst.setInt(5, v.getCantidad());
            cst.setDouble(6, v.getPrecio());
            cst.setDate(7, v.getFecha() != null ? new java.sql.Date(v.getFecha().getTime()) : null);
            
            try (ResultSet rs = cst.executeQuery()) {
                Ventas objVenta;
                while (rs.next()) {
                    objVenta = new Ventas(
                        rs.getInt("codigoVenta"),
                        rs.getInt("codigoCliente"),
                        rs.getInt("codigoProducto"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"),
                        rs.getDate("fecha")
                    );
                    lista.add(objVenta);
                }
            }
            
        } catch (Exception ex) {
            System.out.println("operacionesLectura-Error:" + ex.getMessage());
        }
        return lista;
    }
}