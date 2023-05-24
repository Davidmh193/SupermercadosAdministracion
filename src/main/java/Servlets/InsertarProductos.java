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

import DAO.Supermercados;
import DTO.AdministracionBBDD;

/**
 * Servlet implementation class InsertarProductos
 */
@WebServlet("/InsertarProducto")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdministracionBBDD baseDatos = new AdministracionBBDD();
		String aviso = null;
		aviso = request.getParameter("aviso");
		ArrayList<Supermercados> supermercados = baseDatos.getSupermercado();
		request.setAttribute("aviso", aviso);
		request.setAttribute("supermercados", supermercados);
		request.getRequestDispatcher("InsertarProductos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdministracionBBDD bbdd = new AdministracionBBDD();

		//Datos producto
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		String caducidad = request.getParameter("caducidad");
		Date FechaCaducidad = null;
		Date hoy = new Date();
		int desplegable = Integer.parseInt(request.getParameter("Desplegable"));

		// Lista de id's de los supermercados a los que pertenece el producto
		String[] supermercados = request.getParameterValues("supermercados");
		
		try {
			FechaCaducidad = new SimpleDateFormat("yyyy-MM-dd").parse(caducidad);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (precio > 0 && cantidad > 0 && FechaCaducidad.after(hoy) && !bbdd.verificarCodigo(Integer.parseInt(codigo))) {

			try {
				//Inserta producto en la BBDD
				bbdd.insertarProductos(codigo, nombre, cantidad, precio, FechaCaducidad, desplegable);
				
				//Coje el ultimo id del producto insertado y rellena la tabla de la relacion Producto <-> Supermercado
				bbdd.insertarProductosSuper(bbdd.getUltimaId(), supermercados);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("AdministracionSupermercados").forward(request, response);

		} else {

			response.sendRedirect(request.getContextPath() + "/InsertarProducto?aviso=error");

		}

	}

}
