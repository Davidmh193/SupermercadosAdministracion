package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Productos;
import DTO.AdministracionBBDD;
/**
 * Servlet implementation class BuscadorProductos
 */
@WebServlet("/BuscadorProductos")
public class BuscadorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdministracionBBDD buscador = new AdministracionBBDD();
        ArrayList<Productos> pruductos = null;
		try {
			pruductos = buscador.getProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        String busqueda = request.getParameter("buscador");
        
        if (busqueda != null) {
            busqueda = busqueda.toLowerCase();
            Iterator<Productos> iterator = pruductos.iterator();
            
            while (iterator.hasNext()) {
                Productos producto = iterator.next();

                if (!producto.getNombre().toLowerCase().contains(busqueda) && !producto.getCodigo().contains(busqueda)) {
                    iterator.remove();
                }
            }
        }

        request.setAttribute("pruductos", pruductos);
        request.getRequestDispatcher("AdministracionSupermercados.jsp").forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
