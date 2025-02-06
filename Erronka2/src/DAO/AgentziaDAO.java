package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modeloa.Agentzia;

public class AgentziaDAO {

	private Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}
	
	
	public List<Agentzia> lortuAgentziaGuztiak() {
		List<Agentzia> agentziak = new ArrayList<>();
	    String kontsulta = "SELECT IDAgentzia, izenaAgentzia, logoa, kolorea, Erabiltzaile, Pasahitza, kodAgMota, kodLangKop FROM agentzia";
	    try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
	        while (rs.next()) {
	            // Crear el objeto Agentzia y añadirlo a la lista
	            int idAgentzia = rs.getInt("IDAgentzia");
	            String izenaAgentzia = rs.getString("izenaAgentzia");
	            String logoAgentzia = rs.getString("logoa");
	            String koloreAgentzia = rs.getString("kolorea");
	            String erabiltzailea = rs.getString("Erabiltzaile");
	            String pasahitza = rs.getString("Pasahitza");
	            String kodAgentzia = rs.getString("kodAgMota");
	            String kodLangKop = rs.getString("kodLangKop");
	            Agentzia agentzia = new Agentzia(idAgentzia, izenaAgentzia, logoAgentzia, koloreAgentzia, erabiltzailea, pasahitza, kodAgentzia, kodLangKop, null);  // Ajusta según el constructor de tu clase Aireportua
	            agentziak.add(agentzia);
	        }
	    } catch (SQLException e) {
	        System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
	    }

	    return agentziak;
	}

	public boolean sartuLogin(String erabiltzaile, String pasahitza) {
	    String sql = "SELECT Erabiltzaile, Pasahitza FROM agentzia WHERE Erabiltzaile = ? AND Pasahitza = ?";
	    
	    System.out.println("Usuario: " + erabiltzaile);
	    System.out.println("Contraseña: " + pasahitza);

	    
	    try (Statement stmt = konexioa.createStatement(); PreparedStatement ps = konexioa.prepareStatement(sql)) {
	        ps.setString(1, erabiltzaile);  // Usamos el usuario que se pasa como parámetro
	        ps.setString(2, pasahitza);     // Usamos la contraseña que se pasa como parámetro
	        
	        ResultSet rs = ps.executeQuery();
	        
	        // Si encontramos algún resultado, significa que el login es válido
	        return rs.next();
	        
	    } catch (SQLException e) {
	        System.err.println("Error al validar el login: " + e.getMessage());
	        return false;
	    }
	}

/*
	public List<Agentzia> lortuAgentziaGuztiak() {
		List<Agentzia> agentziak = new ArrayList<>();
		String sql = "SELECT * FROM Agentzia";

		try (Statement stmt = konexioa.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Agentzia agentzia = new Agentzia(sql, sql, sql, sql, sql, sql, sql, sql, null);
				agentzia.setIdentifikatzailea(rs.getString("IDAgentzia"));
				agentzia.setIzena(rs.getString("izenaAgentzia"));
				agentzia.setLogoa(rs.getString("logoa"));
				agentzia.setMarkaKolorea(rs.getString("kolorea"));
				agentzia.setErabiltzaile(rs.getString("erabiltzaile"));
				agentzia.setAgentziaMota(rs.getString("KodAgMota"));
				agentzia.setLangileKopurua(rs.getString("KodLangKop"));
				agentziak.add(agentzia);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Para ver el detalle del error
			System.out.println("Errorea Herrialdeak eskuratzen: " + e.getMessage());
		}

		return agentziak;
	}
	*/

	public boolean sartuAgentzia(Agentzia agentzia) {
		String sql = "INSERT INTO Agentzia (izenaAgentzia, logoa, kolorea, KodLangKop, KodAgMota, erabiltzaile, pasahitza) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = konexioa.prepareStatement(sql)) {
			ps.setString(2, agentzia.getIzena());
			ps.setString(3, agentzia.getLogoa());
			ps.setString(4, agentzia.getMarkaKolorea());
			ps.setString(5, agentzia.getLangileKopurua());
			ps.setString(6, agentzia.getAgentziaMota());
			ps.setString(7, agentzia.getErabiltzaile());
			ps.setString(8, agentzia.getPasahitza());

			int filasAfectadas = ps.executeUpdate();
			return filasAfectadas > 0; // Devuelve true si la inserción fue exitosa
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al insertar Agentzia: " + e.getMessage());
			return false;
		}
	}
}
