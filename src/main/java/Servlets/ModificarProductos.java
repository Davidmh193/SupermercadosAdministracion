package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Seccion;
import DAO.Supermercados;
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
		AdministracionBBDD baseDatos = new AdministracionBBDD();
		
		ArrayList<Supermercados> supermercados = baseDatos.getSupermercado();
		ArrayList<Seccion> secciones = baseDatos.getSecciones();		
	
		request.setAttribute("secciones", secciones);
		request.setAttribute("supermercados", supermercados);
		 request.getRequestDispatcher("/AdministracionSupermercados").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdministracionBBDD modificarProductos = new AdministracionBBDD();
		String id = request.getParameter("id");
		String codigo = (request.getParameter("codigo"));
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		String caducidad = request.getParameter("caducidad");
		int desplegable = Integer.parseInt(request.getParameter("Desplegable"));
		Date hoy = new Date();
		Date FechaCaducidad = null;
		String[] supermercados = request.getParameterValues("supermercados");
		
		
		try {
			FechaCaducidad = new SimpleDateFormat("yyyy-MM-dd").parse(caducidad);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (precio > 0 && cantidad > 0 && FechaCaducidad.after(hoy) && !modificarProductos.verificarCodigo(Integer.parseInt(codigo))) {

			try {
				//elimina de la BBDD
				modificarProductos.eliminarProducto(id);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				//Inserta producto en la BBDD
				modificarProductos.insertarModificacionPro(id,codigo, nombre, cantidad, precio, FechaCaducidad,desplegable);
				modificarProductos.insertarProductosSuper(modificarProductos.getUltimaId(), supermercados);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		

	
	}
		request.getRequestDispatcher("/AdministracionSupermercados").forward(request, response);
}
}
