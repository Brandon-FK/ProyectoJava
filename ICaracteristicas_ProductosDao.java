package com.idat.dao;

import java.util.List;

import com.idat.entidades.Caracteristicas_Productos;

public interface ICaracteristicas_ProductosDao {
	

	int OperacionesEscritura(String indicador, Caracteristicas_Productos cp);
	
	List<Caracteristicas_Productos> OperacionesLectura(String indicador, Caracteristicas_Productos cp);
	

}
