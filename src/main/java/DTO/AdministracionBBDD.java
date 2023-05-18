package DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import DAO.Conector;
import DAO.Productos;
import DAO.Supermercados;

public class AdministracionBBDD {
	
	//visualiza las cosas en la tabla 
	
	public ArrayList<Productos> getProductos() throws SQLException {
		ArrayList<Productos> pruductos = new ArrayList<>();
		Conector conector = new Conector();
		SecionesBBDD seccion = new SecionesBBDD();
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
			pro.setSeccion(seccion.getsecciones(resultado.getInt("id_seccion")));
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
	
	
	//Inserta productos a la BBDD
	public void insertarProductos( String codigo, String nombre,
			int cantidad, double precio, Date fecha, int secciones ) throws ClassNotFoundException {
		try {
			Conector conector = new Conector();
			conector.conectar();

			PreparedStatement pSt = conector.getCon().prepareStatement(
					"INSERT INTO productos (codigo, nombre,cantidad,precio,caducidad,id_seccion ) Values (?,?,?,?,?,?)");

			pSt.setString(1, codigo);
			pSt.setString(2, nombre);
			pSt.setInt(3, cantidad);
			pSt.setDouble(4, precio);
			pSt.setDate(5, new java.sql.Date(fecha.getTime()));
			pSt.setInt(6, secciones);
			pSt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void eliminarProducto(String id) throws ClassNotFoundException {
		String sentencia = "DELETE FROM productos WHERE id=?";
		try {
			Conector conector = new Conector();
			conector.conectar();

			PreparedStatement pSt = conector.getCon().prepareStatement(sentencia);
			pSt.setString(1, id);
			pSt.execute();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public boolean verificarCodigo(int codigo) {
		boolean cod= false;
		try {
			
			Conector conector = new Conector();
			conector.conectar();

			PreparedStatement pSt = conector.getCon().prepareStatement(
					"SELECT codigo FROM productos WHERE codigo=?");
			pSt.setInt(1, codigo);
		
			ResultSet resultado = pSt.executeQuery();
			
			while( resultado.next()) {
			cod= true;
			System.out.println("Funciona");
			}	
					
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	return cod;

	}
	}
