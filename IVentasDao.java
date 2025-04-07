package com.idat.dao;

import java.util.List;

import com.idat.entidades.Ventas;

public interface IVentasDao {
	
	int OperacionesEscritura(String indicador, Ventas v);
	
	List<Ventas> OperacionesLectura(String indicador, Ventas v);

}
