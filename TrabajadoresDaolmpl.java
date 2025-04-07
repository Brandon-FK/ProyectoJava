package com.idat.dao.daolmpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.idat.conexion.ConectarSql;
import com.idat.dao.ITrabajadoresDao;
import com.idat.entidades.Trabajadores;

public class TrabajadoresDaolmpl implements ITrabajadoresDao {
	@Override
    public int operacionesEscritura(String indicador, Trabajadores t) {
        int procesar = -1;
        String query = "{call usp_trabajador_crud(?,?,?,?,?,?)}";
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, t.getCodigoUsuario());
            cst.setString(3, t.getNombre());
            cst.setString(4, t.getUsuario());
            cst.setString(5, t.getContraseña());
            cst.setString(6, t.getRol());
            
            procesar = cst.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("operacionesEscritura-Error:" + ex.getMessage());
        }
        return procesar;
    }

    @Override
    public List<Trabajadores> operacionesLectura(String indicador, Trabajadores t) {
        List<Trabajadores> lista = new ArrayList<Trabajadores>();
        String query = "{call usp_trabajador_crud(?,?,?,?,?,?)}";
        
        try (Connection con = ConectarSql.conectar(); 
             CallableStatement cst = con.prepareCall(query)) {
            
            cst.setString(1, indicador);
            cst.setInt(2, t.getCodigoUsuario());
            cst.setString(3, t.getNombre());
            cst.setString(4, t.getUsuario());
            cst.setString(5, t.getContraseña());
            cst.setString(6, t.getRol());
            
            try (ResultSet rs = cst.executeQuery()) {
                Trabajadores objTra;
                while (rs.next()) {
                    objTra = new Trabajadores(
                        rs.getInt("codigoUsuario"),
                        rs.getString("nombre"),
                        rs.getString("usuario"),
                        rs.getString("contraseña"),
                        rs.getString("rol")
                    );
                    lista.add(objTra);
                }
            }
            
        } catch (Exception ex) {
            System.out.println("operacionesLectura-Error:" + ex.getMessage());
        }
        return lista;
    }
   
}
