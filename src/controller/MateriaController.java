package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Materia;
import model.Nivel;

public class MateriaController {
	public static List<Materia> findInNivel(int id){
		List<Materia> lm = new ArrayList<Materia>();
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.materia where idnivel = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Materia m;
			while (rs.next()) {
				m = new Materia();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setIdNivel(rs.getInt("idNivel"));
				m.setCodigo(rs.getString("codigo"));
				m.setUrlClassroom(rs.getString("urlClassroom"));
				m.setAdmiteMatricula(rs.getBoolean("admiteMatricula"));
				m.setFechaInicio(rs.getDate("fechaInicio"));
				
				lm.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
			return lm;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lm;
	}
	
	public static void save(Materia m) {
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update nivelesymaterias.materia set nombre = ?, codigo = ?, urlClassroom = ?, admiteMatricula = ?, fechaInicio = ? where id = ?");
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getCodigo());
			ps.setString(3, m.getUrlClassroom());
			ps.setBoolean(4, m.isAdmiteMatricula());
			ps.setDate(5, m.getFechaInicio());
			ps.setInt(6, m.getId());
			
			int columnasAfectadas = ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
