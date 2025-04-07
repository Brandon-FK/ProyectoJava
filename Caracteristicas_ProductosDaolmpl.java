package com.idat.dao.daolmpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.idat.conexion.ConectarSql;
import com.idat.dao.ICaracteristicas_ProductosDao;
import com.idat.entidades.Caracteristicas_Productos;

public class Caracteristicas_ProductosDaolmpl implements ICaracteristicas_ProductosDao {

    @Override
    public int OperacionesEscritura(String indicador, Caracteristicas_Productos cp) {
        int procesar = -1;
        String query = "{call usp_caracteristicas_producto_crud(?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, cp.getCodigoAuto());
            cst.setString(3, cp.getMarca());
            cst.setString(4, cp.getModelo());
            cst.setInt(5, cp.getAnio());
            cst.setString(6, cp.getColor());
            cst.setString(7, cp.getTipoCombustible());
            cst.setDouble(8, cp.getCilindrada());
            cst.setInt(9, cp.getNumeroPuertas());
            cst.setBoolean(10, cp.isEsAutomatico());
            cst.setInt(11, cp.getCodigoProducto());
            
            procesar = cst.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("operacionesEscritura-Error:" + ex.getMessage());
        }
        return procesar;
    }

    @Override
    public List<Caracteristicas_Productos> OperacionesLectura(String indicador, Caracteristicas_Productos cp) {
        List<Caracteristicas_Productos> lista = new ArrayList<Caracteristicas_Productos>();
        String query = "{call usp_caracteristicas_producto_crud(?,?,?,?,?,?,?,?,?,?,?)}";
        
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, cp.getCodigoAuto());
            cst.setString(3, cp.getMarca());
            cst.setString(4, cp.getModelo());
            cst.setInt(5, cp.getAnio());
            cst.setString(6, cp.getColor());
            cst.setString(7, cp.getTipoCombustible());
            cst.setDouble(8, cp.getCilindrada());
            cst.setInt(9, cp.getNumeroPuertas());
            cst.setBoolean(10, cp.isEsAutomatico());
            cst.setInt(11, cp.getCodigoProducto());
            
            try (ResultSet rs = cst.executeQuery()) {
                Caracteristicas_Productos objCaract;
                while (rs.next()) {
                    objCaract = new Caracteristicas_Productos(
                        rs.getInt("codigoAuto"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getString("color"),
                        rs.getString("tipoCombustible"),
                        rs.getDouble("cilindrada"),
                        rs.getInt("numeroPuertas"),
                        rs.getBoolean("esAutomatico"),
                        rs.getInt("codigoProducto")
                    );
                    lista.add(objCaract);
                }
            }
            
        } catch (Exception ex) {
            System.out.println("operacionesLectura-Error:" + ex.getMessage());
        }
        return lista;
    }
}