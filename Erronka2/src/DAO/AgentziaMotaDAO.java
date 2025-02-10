package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Konexioa.ConnectDB;
import modeloa.AgentziaMota;

public class AgentziaMotaDAO {
	
	private static Connection konexioa;
	ConnectDB conexion = new ConnectDB();

	public void setConnection(Connection konexioa) {
		AgentziaMotaDAO.konexioa = konexioa;
	}
	
	public ArrayList<AgentziaMota> lortuAgentziaMotak() {
		
		ArrayList<AgentziaMota> agentziaMotak = new ArrayList<AgentziaMota>();
		
		String kontsulta = "SELECT kodAgMota, deskribapena from agentzia_mota;";
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
			while (rs.next()) {
				String kodAgMota = rs.getString("kodAgMota");
				String motaDeskribapena = rs.getString("deskribapena");
				AgentziaMota agentziaMota = new AgentziaMota(kodAgMota, motaDeskribapena);
				agentziaMotak.add(agentziaMota);
				
			}
		} catch (SQLException e) {
			System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
		}
		return agentziaMotak;
		
		
	}

}
