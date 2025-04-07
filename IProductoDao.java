package com.idat.dao;

import com.idat.entidades.Producto;
import java.util.List;

public interface IProductoDao {
	
	int OperacionesEscritura(String indicador, Producto pd);
	
	List<Producto> OperacionesLectura(String indicador, Producto pd);

}
