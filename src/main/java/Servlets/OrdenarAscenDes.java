package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Productos;
import DTO.AdministracionBBDD;

/**
 * Servlet implementation class OrdenarAscenDes
 */
@WebServlet("/OrdenarAscenDes")
public class OrdenarAscenDes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenarAscenDes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AdministracionBBDD baseDatos = new AdministracionBBDD();
		ArrayList<Productos> pruductos = new ArrayList<Productos>();
		
		
		try {
			pruductos=baseDatos.getProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   if (request.getParameter("orden") != null) {
	            if (request.getParameter("orden").equals("asc")) {
	                 Collections.sort(pruductos, new Comparator<Productos>() {
		
	                	 	public int compare(Productos p1, Productos p2) {
	                            return p1.getCodigo().compareTo(p2.getCodigo());
	                        }
	                    });
	            } else if (request.getParameter("orden").equals("desc")) {
	                 Collections.sort(pruductos, new Comparator<Productos>() {
	                 
	                	 @Override
	                        public int compare(Productos p1, Productos p2) {
	                            return p2.getCodigo().compareTo(p1.getCodigo());
	                        }
	                    });
	            }
	        }
		   request.setAttribute("pruductos", pruductos);
		   request.getRequestDispatcher("AdministracionSupermercados.jsp").forward(request,response);
	            
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
