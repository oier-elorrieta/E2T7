package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Konexioa.ConnectDB;
import modeloa.Agentzia;

public class AgentziaDAO {

	private Connection konexioa;

	// Constructor
    public AgentziaDAO() {
        this.konexioa = ConnectDB.conectar();  // Usamos la clase ConnectDB para obtener la conexión
    }
	
    public List<Agentzia> lortuAgentziaGuztiak() {
        List<Agentzia> agentziak = new ArrayList<>();
        String sql = "SELECT * FROM Agentzia";

        try (Statement stmt = konexioa.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Agentzia agentzia = new Agentzia(sql, sql, sql, sql, sql, sql, sql, sql, null);
                agentzia.setIdentifikatzailea(rs.getString("IDAgentzia"));
                agentzia.setIzena(rs.getString("izena"));
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
	

}

