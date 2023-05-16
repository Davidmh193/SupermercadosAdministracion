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
 * Servlet implementation class InsertarProductos
 */
@WebServlet("/InsertarProductos")
public class InsertarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		String caducidad = request.getParameter("caducidad");
		Date FechaCaducidad = null;
		Date hoy =new Date();
		int desplegable = Integer.parseInt(request.getParameter("Desplegable"));
		
		
		AdministracionBBDD InsertarProducto = new AdministracionBBDD();
		 
		try {
	           	FechaCaducidad = new SimpleDateFormat("yyyy-MM-dd").parse(caducidad);
	           } catch (ParseException e) {
	               e.printStackTrace();
	           }
		
	     if (precio > 0 && cantidad > 0 && FechaCaducidad.after(hoy)) {
	            
	           try {
	           	InsertarProducto.insertarProductos(codigo,nombre,cantidad,precio,FechaCaducidad,desplegable);
	           	
	           	
	   		} catch (ClassNotFoundException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}
	   		
	   		request.getRequestDispatcher("AdministracionSupermercados").forward(request,response);
	    	 
	        } else {
	        
	        	request.getRequestDispatcher("InsertarProductos.jsp").forward(request,response);
	        }
	    
        
		
       
	}

}
