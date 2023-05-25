package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AdministracionBBDD;

/**
 * Servlet implementation class EliminarProductos
 */
@WebServlet("/EliminarProductos")
public class EliminarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String tipo = request.getParameter("tipo");

        AdministracionBBDD AdminProductos = new AdministracionBBDD();

        try {
            switch (tipo) {
                case "productos":
                    int cantidad = AdminProductos.obtenerCantidadProducto(id);

                    if (cantidad > 0) {
                        // Disminuir la cantidad del producto
                        AdminProductos.disminuirCantidadProducto(id);
                    } else {
                        boolean productoEnSupermercados = AdminProductos.verificarProductoEnSupermercados(id);

                        if (productoEnSupermercados) {
                            // Eliminar el producto de los supermercados pero no de la tabla de productos
                            AdminProductos.eliminarProductoDeSupermercados(id);
                        } else {
                            // Eliminar el producto de la BBDD
                            AdminProductos.eliminarProducto(id);
                        }
                    }

                    break;
            }
        } catch (Exception e) {
         
        }
        response.sendRedirect(request.getContextPath() + "/AdministracionSupermercados");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
