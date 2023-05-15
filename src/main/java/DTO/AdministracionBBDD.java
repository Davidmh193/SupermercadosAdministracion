package DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Conector;
import DAO.Productos;
import DAO.Supermercados;

public class AdministracionBBDD {
	
	//visualiza las cosas en la tabla 
	
	public ArrayList<Productos> getProductos() throws SQLException {
		ArrayList<Productos> pruductos = new ArrayList<>();
		Conector conector = new Conector();
		conector.conectar();

		PreparedStatement pSt = conector.getCon().prepareStatement("SELECT * FROM productos");
		ResultSet resultado = pSt.executeQuery();
		while (resultado.next()) {
			Productos pro = new Productos();

			pro.setId(resultado.getInt("id"));
			pro.setCodigo(resultado.getString("codigo"));
			pro.setNombre(resultado.getString("Nombre"));
			pro.setCantidad(resultado.getInt("Cantidad"));
			pro.setPrecio(resultado.getDouble("cantidad"));
			pro.setCaducidad(resultado.getDate("caducidad"));
			pro.setId_seccion(resultado.getInt("id_seccion"));
			pruductos.add(pro);
		}
		pSt.close();
		conector.cerrar();
		return pruductos;

	}
	
	
	//Visualiza los supermercados
	public ArrayList<Supermercados> getSupermercado() throws SQLException {
		ArrayList<Supermercados> supermercado = new ArrayList<>();
		Conector conector = new Conector();
		conector.conectar();

		PreparedStatement pSt = conector.getCon().prepareStatement("SELECT * FROM supermercados");
		ResultSet resultado = pSt.executeQuery();
		while (resultado.next()) {
			Supermercados Superm = new Supermercados();

			Superm.setId(resultado.getInt("id"));
			Superm.setNombre(resultado.getString("nombre"));
			
			supermercado.add(Superm);
		}
		pSt.close();
		conector.cerrar();
		return supermercado;

	}
	
	
	

}
