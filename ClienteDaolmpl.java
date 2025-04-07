package com.idat.dao.daolmpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.idat.conexion.ConectarSql;
import com.idat.dao.IClienteDao;
import com.idat.entidades.Cliente;

public class ClienteDaolmpl implements IClienteDao {

    @Override
    public int OperacionesEscritura(String indicador, Cliente c) {
        int procesar = -1;
        String query = "{call usp_cliente_crud(?,?,?,?,?,?,?)}"; // 7 parámetros
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, c.getCodigoCliente());
            cst.setString(3, c.getNombres());
            cst.setString(4, c.getApellidos());
            cst.setString(5, c.getDireccion());
            cst.setString(6, c.getTelefono());
            cst.setString(7, c.getDNI());
            
            procesar = cst.executeUpdate();
            
        } catch (Exception ex) {
            System.err.println("Error en OperacionesEscritura: " + ex.getMessage());
        }
        return procesar;
    }

    @Override
    public List<Cliente> OperacionesLectura(String indicador, Cliente c) {
        List<Cliente> lista = new ArrayList<Cliente>();
        String query = "{call usp_cliente_crud(?,?,?,?,?,?)}";
        
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, c.getCodigoCliente());
            cst.setString(3, c.getNombres());
            cst.setString(4, c.getApellidos());
            cst.setString(5, c.getDireccion());
            cst.setString(6, c.getTelefono());
            cst.setString(7, c.getDNI());
            
            try (ResultSet rs = cst.executeQuery()) {
            	Cliente objCli;
                while (rs.next()) {
                    objCli = new Cliente(
                        rs.getInt("codigoCliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("dni")
                    );
                    lista.add(objCli);
                }
            }
            
        } catch (Exception ex) {
            System.err.println("Error en OperacionesLectura: " + ex.getMessage());
        }
        return lista;
    }
}