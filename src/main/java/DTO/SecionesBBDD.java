package DTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.Conector;
import DAO.Seccion;

public class SecionesBBDD {
	
	public Seccion getsecciones(int id) throws SQLException {
		Seccion secci = new Seccion();
		Conector conector = new Conector();
		conector.conectar();

		PreparedStatement pSt = conector.getCon().prepareStatement("SELECT * FROM secciones where id=?");
		ResultSet resultado = pSt.executeQuery();
		while (resultado.next()) {

			secci.setId(resultado.getInt("id"));
			secci.setNombre(resultado.getString("nombre"));
		}
		pSt.close();
		conector.cerrar();
		return secci;

	}
	

}
