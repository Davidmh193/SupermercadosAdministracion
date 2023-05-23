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

		AdministracionBBDD baseDatos = new AdministracionBBDD();
		AdministracionBBDD Supermercados1 = new AdministracionBBDD();
		
		ArrayList<Productos> pruductos = new ArrayList<Productos>();
		ArrayList<Supermercados> supermercado = new ArrayList<Supermercados>();
	
		
	
		
		try {
			pruductos= baseDatos.getProductos();
			supermercado= Supermercados1.getSupermercado();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

		
		
		request.setAttribute("pruductos", pruductos);
		request.setAttribute("supermercado", supermercado);
		
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
