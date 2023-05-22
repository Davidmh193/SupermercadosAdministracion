package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AdministracionBBDD;

/**
 * Servlet implementation class ModificarProductos
 */
@WebServlet("/ModificarProductos")
public class ModificarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.getRequestDispatcher("/AdministracionSupermercados").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdministracionBBDD modificarProductos = new AdministracionBBDD();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String Nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		String caducidad = request.getParameter("caducidad");
		int seccion = Integer.parseInt(request.getParameter("seccion"));
		
		Date caducidad1 = null;
		
		
		 try {
			 caducidad1 = new SimpleDateFormat("yyyy-MM-dd").parse(caducidad);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		
		 try {
			modificarProductos.modificarProductos(codigo, Nombre, cantidad, precio, caducidad1, seccion, id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 request.getRequestDispatcher("/AdministracionSupermercados").forward(request,response);
	}

}
