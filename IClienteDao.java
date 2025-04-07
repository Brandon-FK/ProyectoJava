package com.idat.dao;

import com.idat.entidades.Cliente;
import java.util.List;

public interface IClienteDao {
	//Metodos de escritura 
		// insertar, actualizar, eliminar
		//Esto de cliente
		int OperacionesEscritura(String indicador, Cliente c);
		
		//Metodos de lectura
		//consultar, consultarXID
		
		//Esto de Cliente
		List<Cliente> OperacionesLectura(String indicador, Cliente c);

}
