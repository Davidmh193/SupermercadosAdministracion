package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Productos;
import DAO.ProductosSupermercado;
import DAO.Seccion;
import DAO.Supermercados;
import DTO.AdministracionBBDD;

/**
 * Servlet implementation class AdministracionSupermercados
 */
@WebServlet("/AdministracionSupermercados")
public class AdministracionSupermercados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministracionSupermercados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdministracionBBDD baseDatoss = new AdministracionBBDD();
		
		ArrayList<Supermercados> supermercados = baseDatoss.getSupermercado();
		ArrayList<Seccion> secciones = baseDatoss.getSecciones();		
	
		request.setAttribute("secciones", secciones);
		request.setAttribute("supermercados", supermercados);
		
		
		AdministracionBBDD baseDatos = new AdministracionBBDD();
		ArrayList<Productos> pruductos = new ArrayList<Productos>();
		ArrayList<ProductosSupermercado> ProductosSupermercado = new ArrayList<ProductosSupermercado>();
		
		
		try {
			pruductos= baseDatos.getProductos();
			ProductosSupermercado= baseDatos.getProductosSuper();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		
		request.setAttribute("ProductosSupermercado", ProductosSupermercado);
		request.setAttribute("pruductos", pruductos);
		
		request.getRequestDispatcher("AdministracionSupermercados.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
