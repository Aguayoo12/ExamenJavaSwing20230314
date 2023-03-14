package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CentroEducativo;

public class CentroEducativoController {

	public static List<CentroEducativo> findAll(){
		List<CentroEducativo> lce = new ArrayList<CentroEducativo>();
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.centroeducativo");
			ResultSet rs = ps.executeQuery();
			CentroEducativo ce;
			while (rs.next()) {
				ce = new CentroEducativo(rs.getInt("id"), rs.getString("descripcion"));
				lce.add(ce);
			}
			rs.close();
			ps.close();
			conn.close();
			return lce;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lce;
	}
	
}
