package com.idat.dao;

import java.util.List;

import com.idat.entidades.Trabajadores;

public interface ITrabajadoresDao {
	// Metodos de escritura
	// insertar, actualizar, eliminar
	int operacionesEscritura(String indicador, Trabajadores t);
	// Metodos de lectura
	// consultar, consultarXId
	List<Trabajadores> operacionesLectura(String indicador, Trabajadores t);

	
}
