package com.idat.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarSql {
	public static void main(String [] args) {
		Connection con = conectar();
		if (con!= null) {
			System.out.println("Conectado");
		}else {
			System.out.println("No conectado");
		}
	}
	public static Connection conectar() {
		Connection con = null;
		try {
			String cadenaCon= "jdbc:sqlserver://localhost:1433;"+
					"user=sa; password=12345;database=VentAutos;"+ 
					"encrypt=false;";
			con = DriverManager.getConnection(cadenaCon);
		}catch(Exception ex) {
			System.out.println("Error : "+ ex.getMessage());
		}
		return con;
	}
	

}