package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CentroEducativo;
import model.Nivel;

public class NivelController {
	public static List<Nivel> findInCenter(int id){
		List<Nivel> ln = new ArrayList<Nivel>();
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.nivel where idCentro = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Nivel n;
			while (rs.next()) {
				n = new Nivel(rs.getInt("id"), rs.getString("descripcion"), rs.getInt("idCentro"));
				ln.add(n);
			}
			rs.close();
			ps.close();
			conn.close();
			return ln;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ln;
	}
}
