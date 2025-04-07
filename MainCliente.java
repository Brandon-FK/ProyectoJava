package com.idat.main;

import java.util.List;

import com.idat.dao.IClienteDao;
import com.idat.dao.daolmpl.ClienteDaolmpl;
import com.idat.entidades.Cliente;


public class MainCliente {

    public static void main(String[] args) {
        IClienteDao dao = new ClienteDaolmpl();
        
        // Consulta general de clientes
        List<Cliente> lista = dao.OperacionesLectura("consultar", new Cliente());
        System.out.println("\n=== CLIENTES REGISTRADOS (" + lista.size() + ") ===");
        for (Cliente c : lista) {
            System.out.println(
                "Código: " + c.getCodigoCliente() + 
                " | Nombre: " + c.getNombres() + " " + c.getApellidos() +
                " | DNI: " + c.getDNI() + 
                " | Teléfono: " + c.getTelefono()
            );
        }
        
     //* Forma alternativa de consulta (no utilizada actualmente)
        //List<Cliente> lista = dao.operacionesLectura("consultar", new Cliente());
        //System.out.println("Total registros: "+ lista.size());

        
        //Cliente objCliente = new Cliente();
        //objCliente.setCodigoCliente(0); 
        //objCliente.setNombres("");
        //objCliente.setApellidos("");
        //objCliente.setTelefono("");
        //objCliente.setDni("");
        //objCliente.setDireccion("");
        
        //int procesar = dao.operacionesEscritura("eliminar", objCliente);
        //System.out.println("Procesar: "+ procesar);
        
        //* 
    }
}