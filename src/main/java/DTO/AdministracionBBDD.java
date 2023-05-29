package DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import DAO.Conector;
import DAO.Productos;
import DAO.ProductosSupermercado;
import DAO.Seccion;
import DAO.Supermercados;

public class AdministracionBBDD {

	// visualiza las cosas en la tabla

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

	// Visualiza los supermercados
	public ArrayList<Supermercados> getSupermercado() {
		ArrayList<Supermercados> supermercado = new ArrayList<>();
		Conector conector = new Conector();
		conector.conectar();

		try {
			PreparedStatement pSt = conector.getCon().prepareStatement("SELECT * FROM supermercados");
			ResultSet resultado = pSt.executeQuery();
			while (resultado.next()) {
				Supermercados Superm = new Supermercados();

				Superm.setId(resultado.getInt("id"));
				Superm.setNombre(resultado.getString("nombre"));

				supermercado.add(Superm);
			}
			pSt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		conector.cerrar();
		return supermercado;

	}

	// Inserta productos a la BBDD
	public void insertarProductos(String codigo, String nombre, int cantidad, double precio, Date caducidad, int secciones)
			throws ClassNotFoundException {
		try {
			Conector conector = new Conector();
			conector.conectar();

			PreparedStatement pSt = conector.getCon().prepareStatement(
					"INSERT INTO productos (codigo, nombre,cantidad,precio,caducidad,id_seccion ) Values (?,?,?,?,?,?)");

			pSt.setString(1, codigo);
			pSt.setString(2, nombre);
			pSt.setInt(3, cantidad);
			pSt.setDouble(4, precio);
			pSt.setDate(5, new java.sql.Date(caducidad.getTime()));
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
		boolean cod = false;
		try {

			Conector conector = new Conector();
			conector.conectar();

			PreparedStatement pSt = conector.getCon().prepareStatement("SELECT codigo FROM productos WHERE codigo=?");
			pSt.setInt(1, codigo);

			ResultSet resultado = pSt.executeQuery();

			while (resultado.next()) {
				cod = true;
				System.out.println("Funciona");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return cod;

	}

	public void modificarProductos(int codigo, String nombre, int cantidad, double precio, Date caducidad, int seccion,
			int id) throws ClassNotFoundException {

		try {
			Conector conector = new Conector();
			conector.conectar();

			PreparedStatement pSt = conector.getCon().prepareStatement(
					"UPDATE productos SET codigo=? , nombre=?, cantidad=?,precio=?,caducidad=?,id_seccion=?  WHERE id = ?");
			pSt.setInt(1, codigo);
			pSt.setString(2, nombre);
			pSt.setInt(3, cantidad);
			pSt.setDouble(4, precio);
			pSt.setDate(5, new java.sql.Date(caducidad.getTime()));
			pSt.setInt(6, seccion);
			pSt.setInt(7, id);
			pSt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<ProductosSupermercado> getProductosSuper() throws SQLException {
		ArrayList<ProductosSupermercado> ProductosSupermercado = new ArrayList<>();
		Conector conector = new Conector();

		conector.conectar();

		PreparedStatement pSt = conector.getCon().prepareStatement("SELECT * FROM productos_supermercados");
		ResultSet resultado = pSt.executeQuery();
		while (resultado.next()) {
			ProductosSupermercado pro = new ProductosSupermercado();

			pro.setId(resultado.getInt("id"));
			pro.setId_productos(resultado.getInt("id_producto"));
			pro.setId_supermercado(resultado.getInt("id_supermercado"));
			ProductosSupermercado.add(pro);
		}
		pSt.close();
		conector.cerrar();
		return ProductosSupermercado;

	}
	
	public int getUltimaId() {
	    int id = 0;
	    Conector c = new Conector();
	    c.conectar();
	    
	    try {
	        PreparedStatement pSt = c.getCon().prepareStatement("SELECT max(id) FROM productos");
	        ResultSet resultado = pSt.executeQuery();
	        resultado.next();
	        id = resultado.getInt(1);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    c.cerrar();
	    return id;
	}

	public void insertarProductosSuper(int producto, String[] supermercados) throws ClassNotFoundException {
	    try {
	        Conector conector = new Conector();
	        conector.conectar();

	        PreparedStatement pSt = conector.getCon().prepareStatement(
	                "INSERT INTO productos_supermercados (id_producto, id_supermercado) VALUES (?, ?)");
	        pSt.setInt(1, producto);

	        for (String supermercado : supermercados) {
	            pSt.setString(2, supermercado);
	            pSt.execute();
	        }

	        conector.cerrar();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public int obtenerCantidadProducto(String id) {
	    Conector c = new Conector();
	    c.conectar();
	    int cantidad = 0;
	    
	    try {
	        PreparedStatement pSt = c.getCon().prepareStatement("SELECT cantidad FROM productos WHERE id=?");
	        pSt.setInt(1, Integer.parseInt(id));
	        ResultSet resultado = pSt.executeQuery();
	        
	        if (resultado.next()) {
	            cantidad = resultado.getInt("cantidad");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    c.cerrar();
	    return cantidad;
	}

	public void disminuirCantidadProducto(String id) {
	    Conector c = new Conector();
	    c.conectar();
	    
	    try {
	        PreparedStatement pSt = c.getCon().prepareStatement("UPDATE productos SET cantidad = cantidad - 1 WHERE id = ?");
	        pSt.setInt(1, Integer.parseInt(id));
	        pSt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    c.cerrar();
	}
	
	public boolean verificarProductoEnSupermercados(String id) {
	    Conector c = new Conector();
	    c.conectar();
	    boolean productoEnSupermercados = false;
	    
	    try {
	        PreparedStatement pSt = c.getCon().prepareStatement(
	                "SELECT id_producto FROM productos_supermercados WHERE id_producto = ?");
	        pSt.setInt(1, Integer.parseInt(id));
	        ResultSet resultado = pSt.executeQuery();
	        
	        productoEnSupermercados = resultado.next();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    c.cerrar();
	    return productoEnSupermercados;
	}

	public void eliminarProductoDeSupermercados(String id) {
	    Conector c = new Conector();
	    c.conectar();
	    
	    try {
	        PreparedStatement pSt = c.getCon().prepareStatement(
	                "DELETE FROM productos_supermercados WHERE id_producto = ?");
	        pSt.setInt(1, Integer.parseInt(id));
	        pSt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    c.cerrar();
	}
	public ArrayList<Seccion> getSecciones() {
		ArrayList<Seccion> secciones = new ArrayList<>();
		Conector conector = new Conector();
		conector.conectar();

		try {
			PreparedStatement pSt = conector.getCon().prepareStatement("SELECT * FROM secciones");
			ResultSet resultado = pSt.executeQuery();
			while (resultado.next()) {
				Seccion sec = new Seccion();

				sec.setId(resultado.getInt("id"));
				sec.setNombre(resultado.getString("nombre"));

				secciones.add(sec);
			}
			pSt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		conector.cerrar();
		return secciones;

	}
	
	
	// Inserta productos a la BBDD
		public void insertarModificacionPro(String id,String codigo, String nombre, int cantidad, double precio, Date caducidad, int secciones)
				throws ClassNotFoundException {
			try {
				Conector conector = new Conector();
				conector.conectar();

				PreparedStatement pSt = conector.getCon().prepareStatement(
						"INSERT INTO productos (id,codigo, nombre,cantidad,precio,caducidad,id_seccion ) Values (?,?,?,?,?,?,?)");
				pSt.setString(1, id);
				pSt.setString(2, codigo);
				pSt.setString(3, nombre);
				pSt.setInt(4, cantidad);
				pSt.setDouble(5, precio);
				pSt.setDate(6, new java.sql.Date(caducidad.getTime()));
				pSt.setInt(7, secciones);
				pSt.execute();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	

}
	