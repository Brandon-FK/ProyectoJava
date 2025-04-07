package com.idat.main;

import java.util.List;
import com.idat.dao.ITrabajadoresDao;
import com.idat.dao.daolmpl.TrabajadoresDaolmpl;
import com.idat.entidades.Trabajadores;

public class MainTrabajadores {

    public static void main(String[] args) {
        ITrabajadoresDao dao = new TrabajadoresDaolmpl();
        
        // Consulta general
        List<Trabajadores> lista = dao.operacionesLectura("consultar", new Trabajadores());
        System.out.println("\n=== TRABAJADORES REGISTRADOS ===");
        for (Trabajadores t : lista) {
            System.out.println(
                t.getCodigoUsuario() + " | " + 
                t.getUsuario() + " | " + 
                t.getNombre() + " | Rol: " + 
                t.getRol()
            );
        }

        /*List<Trabajador> lista = dao.operacionesLectura("consultar", new Trabajador());
        System.out.println("Total trabajadores: " + lista.size());

        // Ejemplo de eliminación
        Trabajador objTrab = new Trabajador();
        objTrab.setCodigoUsuario(0);
        objTrab.setNombre("");
        objTrab.setUsuario("");
        objTrab.setContraseña("");
        objTrab.setRol("");
        
        int resultado = dao.operacionesEscritura("eliminar", objTrab);
        System.out.println("Resultado eliminación: " + resultado);
        */
    }
}