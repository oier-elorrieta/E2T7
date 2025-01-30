package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Konexioa.ConnectDB;
import modeloa.*;

public class HerrialdeaDAO {
	
	private Connection konexioa;
	
	 // Constructor
    public HerrialdeaDAO() {
        this.konexioa = ConnectDB.conectar();  // Usamos la clase ConnectDB para obtener la conexión
    }
	
    public List<Herrialdea> lortuHerrialdeGuztiak() {
        List<Herrialdea> herrialdeak = new ArrayList<>();
        String sql = "SELECT * FROM Herrialdea";

        try (Statement stmt = konexioa.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Herrialdea herrialdea = new Herrialdea(sql, sql);
                herrialdea.setKodea(rs.getString("kodHerrialdea"));
                herrialdea.setHerrialdea(rs.getString("deskribapena"));
                herrialdeak.add(herrialdea);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Para ver el detalle del error
            System.out.println("Errorea Herrialdeak eskuratzen: " + e.getMessage());
        }

        return herrialdeak;
    }
	

}
